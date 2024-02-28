package org.example.cloudevents;

import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventData;
import io.cloudevents.core.format.EventDeserializationException;
import io.cloudevents.core.format.EventFormat;
import io.cloudevents.core.format.EventSerializationException;
import io.cloudevents.rw.CloudEventDataMapper;
import io.confluent.kafka.schemaregistry.avro.AvroSchemaProvider;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClientFactory;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class KafkaAvroFormat implements EventFormat {

    public static final String AVRO_SR_CONTENT_TYPE = "application/cloudevents+avroschemaregistry";

    private CloudEventAvroFormat innerAvroCompactFormat;
    private KafkaAvroSerializer kafkaAvroSerializer;

    public KafkaAvroFormat(Map<String, ?> config, boolean isKey) {
        innerAvroCompactFormat = new CloudEventAvroFormat();

        KafkaAvroSerializerConfig tmpConfig = new KafkaAvroSerializerConfig(config);
        List<String> urls = tmpConfig.getSchemaRegistryUrls();
        int latestCacheTtl = tmpConfig.getMaxSchemasPerSubject();
        Map<String, Object> originals = tmpConfig.originalsWithPrefix("");
        SchemaRegistryClient schemaRegistryClient = SchemaRegistryClientFactory.newClient(urls, latestCacheTtl, Collections.singletonList(new AvroSchemaProvider()), originals, config.requestHeaders());

        kafkaAvroSerializer = new KafkaAvroSerializer(schemaRegistryClient);
        kafkaAvroSerializer.configure(config, isKey);
    }

    @Override
    public byte[] serialize(CloudEvent cloudEvent) throws EventSerializationException {
        cloudEvent.getData()

        kafkaAvroSerializer.
        return new byte[0];
    }

    @Override
    public CloudEvent deserialize(byte[] bytes, CloudEventDataMapper<? extends CloudEventData> cloudEventDataMapper) throws EventDeserializationException {
        return null;
    }

    @Override
    public String serializedContentType() {
        return AVRO_SR_CONTENT_TYPE;
    }
}
