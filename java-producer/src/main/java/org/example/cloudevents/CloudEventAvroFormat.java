package org.example.cloudevents;

import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.core.format.EventDeserializationException;
import io.cloudevents.core.format.EventFormat;
import io.cloudevents.core.format.EventSerializationException;
import io.cloudevents.rw.CloudEventDataMapper;

import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link EventFormat} for the Avro Compact format.
 * This format is resolvable with {@link io.cloudevents.core.provider.EventFormatProvider} using the content type {@link #AVRO_COMPACT_CONTENT_TYPE}.
 */
public class CloudEventAvroFormat implements EventFormat {

    public static final String AVRO_COMPACT_CONTENT_TYPE = "application/cloudevents+avro";

    @Override
    public byte[] serialize(CloudEvent from) throws EventSerializationException {
        try {

            // extensions
            Map<String, Object> extensions = new HashMap<>();
            for (String name : from.getExtensionNames()) {
                Object value = from.getExtension(name);
                if (value instanceof byte[])
                    value = ByteBuffer.wrap((byte[]) value);
                else if (value instanceof OffsetDateTime)
                    value = ((OffsetDateTime) value).toInstant();
                extensions.put(name,  value);
            }

            to.setSource(from.getSource().toString())
                    .setType(from.getType())
                    .setId(from.getId())
                    .setSubject(from.getSubject())
                    .setDatacontenttype(from.getDataContentType())
                    .setExtensions(extensions);

            if (from.getTime() != null)
                to.setTime(from.getTime().toInstant());
            if (from.getDataSchema() != null)
                to.setDataschema(from.getDataSchema().toString());

            CloudEventData data = from.getData();
            if (data != null)
                to.setData(ByteBuffer.wrap(data.toBytes()));
            return to.build().toByteBuffer().array();
        } catch (Exception e) {
            throw new EventSerializationException(e);
        }
    }

    @Override
    public CloudEvent deserialize(byte[] bytes, CloudEventDataMapper<? extends CloudEventData> mapper) throws EventDeserializationException {
        try {
            CloudEventBuilder to = CloudEventBuilder.v1()
                    .withSource(URI.create(from.getSource()))
                    .withType(from.getType())
                    .withId(from.getType())
                    .withSubject(from.getSubject())
                    .withDataContentType(from.getDatacontenttype());

            if (from.getTime() != null)
                to.withTime(from.getTime().atOffset(ZoneOffset.UTC));
            if (from.getDataschema() != null)
                to.withDataSchema(URI.create(from.getDataschema()));

            // extensions
            for (Map.Entry<String, Object> entry : from.getExtensions().entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                // Avro supports boolean, int, string, bytes
                if (value instanceof Boolean)
                    to.withExtension(name, (boolean) value);
                else if (value instanceof Integer)
                    to.withExtension(name, (int) value);
                else if (value instanceof Instant)
                    to.withExtension(name, ((Instant) value).atOffset(ZoneOffset.UTC));
                else if (value instanceof String)
                    to.withExtension(name, (String) value);
                else if (value instanceof ByteBuffer)
                    to.withExtension(name, ((ByteBuffer) value).array());
                else
                    // this cannot happen, if ever seen, must be bug in this library
                    throw new AssertionError(String.format("invalid extension %s unsupported type %s", name, value.getClass()));
            }

            if (from.getData() == null)
                return to.end();
            else {
                CloudEventData data = BytesCloudEventData.wrap(from.getData().array());
                return to.end(mapper.map(data));
            }
        } catch (Exception e) {
            throw new EventDeserializationException(e);
        }
    }

    @Override
    public String serializedContentType() {
        return AVRO_COMPACT_CONTENT_TYPE;
    }
}