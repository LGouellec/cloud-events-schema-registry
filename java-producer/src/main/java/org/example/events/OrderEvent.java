/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.example.events;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Order event avro format */
@org.apache.avro.specific.AvroGenerated
public class OrderEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5404705259974997175L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderEvent\",\"namespace\":\"org.example.events\",\"doc\":\"Order event avro format\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"source\",\"type\":\"string\"},{\"name\":\"specversion\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"datacontenttype\",\"type\":\"string\"},{\"name\":\"dataschema\",\"type\":\"string\"},{\"name\":\"subject\",\"type\":\"string\"},{\"name\":\"time\",\"type\":\"long\"},{\"name\":\"data\",\"type\":{\"type\":\"record\",\"name\":\"OrderEventData\",\"fields\":[{\"name\":\"orderId\",\"type\":\"long\"},{\"name\":\"productId\",\"type\":\"string\"},{\"name\":\"userId\",\"type\":\"string\"},{\"name\":\"quantity\",\"type\":\"long\"}]}}],\"version\":\"1.0\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence source;
  private java.lang.CharSequence specversion;
  private java.lang.CharSequence type;
  private java.lang.CharSequence datacontenttype;
  private java.lang.CharSequence dataschema;
  private java.lang.CharSequence subject;
  private long time;
  private org.example.events.OrderEventData data;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderEvent() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param source The new value for source
   * @param specversion The new value for specversion
   * @param type The new value for type
   * @param datacontenttype The new value for datacontenttype
   * @param dataschema The new value for dataschema
   * @param subject The new value for subject
   * @param time The new value for time
   * @param data The new value for data
   */
  public OrderEvent(java.lang.CharSequence id, java.lang.CharSequence source, java.lang.CharSequence specversion, java.lang.CharSequence type, java.lang.CharSequence datacontenttype, java.lang.CharSequence dataschema, java.lang.CharSequence subject, java.lang.Long time, org.example.events.OrderEventData data) {
    this.id = id;
    this.source = source;
    this.specversion = specversion;
    this.type = type;
    this.datacontenttype = datacontenttype;
    this.dataschema = dataschema;
    this.subject = subject;
    this.time = time;
    this.data = data;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return source;
    case 2: return specversion;
    case 3: return type;
    case 4: return datacontenttype;
    case 5: return dataschema;
    case 6: return subject;
    case 7: return time;
    case 8: return data;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: source = (java.lang.CharSequence)value$; break;
    case 2: specversion = (java.lang.CharSequence)value$; break;
    case 3: type = (java.lang.CharSequence)value$; break;
    case 4: datacontenttype = (java.lang.CharSequence)value$; break;
    case 5: dataschema = (java.lang.CharSequence)value$; break;
    case 6: subject = (java.lang.CharSequence)value$; break;
    case 7: time = (java.lang.Long)value$; break;
    case 8: data = (org.example.events.OrderEventData)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'source' field.
   * @return The value of the 'source' field.
   */
  public java.lang.CharSequence getSource() {
    return source;
  }


  /**
   * Sets the value of the 'source' field.
   * @param value the value to set.
   */
  public void setSource(java.lang.CharSequence value) {
    this.source = value;
  }

  /**
   * Gets the value of the 'specversion' field.
   * @return The value of the 'specversion' field.
   */
  public java.lang.CharSequence getSpecversion() {
    return specversion;
  }


  /**
   * Sets the value of the 'specversion' field.
   * @param value the value to set.
   */
  public void setSpecversion(java.lang.CharSequence value) {
    this.specversion = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.CharSequence getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.CharSequence value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'datacontenttype' field.
   * @return The value of the 'datacontenttype' field.
   */
  public java.lang.CharSequence getDatacontenttype() {
    return datacontenttype;
  }


  /**
   * Sets the value of the 'datacontenttype' field.
   * @param value the value to set.
   */
  public void setDatacontenttype(java.lang.CharSequence value) {
    this.datacontenttype = value;
  }

  /**
   * Gets the value of the 'dataschema' field.
   * @return The value of the 'dataschema' field.
   */
  public java.lang.CharSequence getDataschema() {
    return dataschema;
  }


  /**
   * Sets the value of the 'dataschema' field.
   * @param value the value to set.
   */
  public void setDataschema(java.lang.CharSequence value) {
    this.dataschema = value;
  }

  /**
   * Gets the value of the 'subject' field.
   * @return The value of the 'subject' field.
   */
  public java.lang.CharSequence getSubject() {
    return subject;
  }


  /**
   * Sets the value of the 'subject' field.
   * @param value the value to set.
   */
  public void setSubject(java.lang.CharSequence value) {
    this.subject = value;
  }

  /**
   * Gets the value of the 'time' field.
   * @return The value of the 'time' field.
   */
  public long getTime() {
    return time;
  }


  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(long value) {
    this.time = value;
  }

  /**
   * Gets the value of the 'data' field.
   * @return The value of the 'data' field.
   */
  public org.example.events.OrderEventData getData() {
    return data;
  }


  /**
   * Sets the value of the 'data' field.
   * @param value the value to set.
   */
  public void setData(org.example.events.OrderEventData value) {
    this.data = value;
  }

  /**
   * Creates a new OrderEvent RecordBuilder.
   * @return A new OrderEvent RecordBuilder
   */
  public static org.example.events.OrderEvent.Builder newBuilder() {
    return new org.example.events.OrderEvent.Builder();
  }

  /**
   * Creates a new OrderEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderEvent RecordBuilder
   */
  public static org.example.events.OrderEvent.Builder newBuilder(org.example.events.OrderEvent.Builder other) {
    if (other == null) {
      return new org.example.events.OrderEvent.Builder();
    } else {
      return new org.example.events.OrderEvent.Builder(other);
    }
  }

  /**
   * Creates a new OrderEvent RecordBuilder by copying an existing OrderEvent instance.
   * @param other The existing instance to copy.
   * @return A new OrderEvent RecordBuilder
   */
  public static org.example.events.OrderEvent.Builder newBuilder(org.example.events.OrderEvent other) {
    if (other == null) {
      return new org.example.events.OrderEvent.Builder();
    } else {
      return new org.example.events.OrderEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderEvent>
    implements org.apache.avro.data.RecordBuilder<OrderEvent> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence source;
    private java.lang.CharSequence specversion;
    private java.lang.CharSequence type;
    private java.lang.CharSequence datacontenttype;
    private java.lang.CharSequence dataschema;
    private java.lang.CharSequence subject;
    private long time;
    private org.example.events.OrderEventData data;
    private org.example.events.OrderEventData.Builder dataBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.example.events.OrderEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.source)) {
        this.source = data().deepCopy(fields()[1].schema(), other.source);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.specversion)) {
        this.specversion = data().deepCopy(fields()[2].schema(), other.specversion);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.type)) {
        this.type = data().deepCopy(fields()[3].schema(), other.type);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.datacontenttype)) {
        this.datacontenttype = data().deepCopy(fields()[4].schema(), other.datacontenttype);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.dataschema)) {
        this.dataschema = data().deepCopy(fields()[5].schema(), other.dataschema);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.subject)) {
        this.subject = data().deepCopy(fields()[6].schema(), other.subject);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.time)) {
        this.time = data().deepCopy(fields()[7].schema(), other.time);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.data)) {
        this.data = data().deepCopy(fields()[8].schema(), other.data);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (other.hasDataBuilder()) {
        this.dataBuilder = org.example.events.OrderEventData.newBuilder(other.getDataBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing OrderEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(org.example.events.OrderEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.source)) {
        this.source = data().deepCopy(fields()[1].schema(), other.source);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.specversion)) {
        this.specversion = data().deepCopy(fields()[2].schema(), other.specversion);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.type)) {
        this.type = data().deepCopy(fields()[3].schema(), other.type);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.datacontenttype)) {
        this.datacontenttype = data().deepCopy(fields()[4].schema(), other.datacontenttype);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.dataschema)) {
        this.dataschema = data().deepCopy(fields()[5].schema(), other.dataschema);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.subject)) {
        this.subject = data().deepCopy(fields()[6].schema(), other.subject);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.time)) {
        this.time = data().deepCopy(fields()[7].schema(), other.time);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.data)) {
        this.data = data().deepCopy(fields()[8].schema(), other.data);
        fieldSetFlags()[8] = true;
      }
      this.dataBuilder = null;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'source' field.
      * @return The value.
      */
    public java.lang.CharSequence getSource() {
      return source;
    }


    /**
      * Sets the value of the 'source' field.
      * @param value The value of 'source'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setSource(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.source = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'source' field has been set.
      * @return True if the 'source' field has been set, false otherwise.
      */
    public boolean hasSource() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'source' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearSource() {
      source = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'specversion' field.
      * @return The value.
      */
    public java.lang.CharSequence getSpecversion() {
      return specversion;
    }


    /**
      * Sets the value of the 'specversion' field.
      * @param value The value of 'specversion'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setSpecversion(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.specversion = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'specversion' field has been set.
      * @return True if the 'specversion' field has been set, false otherwise.
      */
    public boolean hasSpecversion() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'specversion' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearSpecversion() {
      specversion = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.CharSequence getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setType(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.type = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearType() {
      type = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'datacontenttype' field.
      * @return The value.
      */
    public java.lang.CharSequence getDatacontenttype() {
      return datacontenttype;
    }


    /**
      * Sets the value of the 'datacontenttype' field.
      * @param value The value of 'datacontenttype'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setDatacontenttype(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.datacontenttype = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'datacontenttype' field has been set.
      * @return True if the 'datacontenttype' field has been set, false otherwise.
      */
    public boolean hasDatacontenttype() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'datacontenttype' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearDatacontenttype() {
      datacontenttype = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'dataschema' field.
      * @return The value.
      */
    public java.lang.CharSequence getDataschema() {
      return dataschema;
    }


    /**
      * Sets the value of the 'dataschema' field.
      * @param value The value of 'dataschema'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setDataschema(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.dataschema = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'dataschema' field has been set.
      * @return True if the 'dataschema' field has been set, false otherwise.
      */
    public boolean hasDataschema() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'dataschema' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearDataschema() {
      dataschema = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'subject' field.
      * @return The value.
      */
    public java.lang.CharSequence getSubject() {
      return subject;
    }


    /**
      * Sets the value of the 'subject' field.
      * @param value The value of 'subject'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setSubject(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.subject = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'subject' field has been set.
      * @return True if the 'subject' field has been set, false otherwise.
      */
    public boolean hasSubject() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'subject' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearSubject() {
      subject = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'time' field.
      * @return The value.
      */
    public long getTime() {
      return time;
    }


    /**
      * Sets the value of the 'time' field.
      * @param value The value of 'time'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setTime(long value) {
      validate(fields()[7], value);
      this.time = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'time' field has been set.
      * @return True if the 'time' field has been set, false otherwise.
      */
    public boolean hasTime() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'time' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearTime() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'data' field.
      * @return The value.
      */
    public org.example.events.OrderEventData getData() {
      return data;
    }


    /**
      * Sets the value of the 'data' field.
      * @param value The value of 'data'.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder setData(org.example.events.OrderEventData value) {
      validate(fields()[8], value);
      this.dataBuilder = null;
      this.data = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'data' field has been set.
      * @return True if the 'data' field has been set, false otherwise.
      */
    public boolean hasData() {
      return fieldSetFlags()[8];
    }

    /**
     * Gets the Builder instance for the 'data' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public org.example.events.OrderEventData.Builder getDataBuilder() {
      if (dataBuilder == null) {
        if (hasData()) {
          setDataBuilder(org.example.events.OrderEventData.newBuilder(data));
        } else {
          setDataBuilder(org.example.events.OrderEventData.newBuilder());
        }
      }
      return dataBuilder;
    }

    /**
     * Sets the Builder instance for the 'data' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public org.example.events.OrderEvent.Builder setDataBuilder(org.example.events.OrderEventData.Builder value) {
      clearData();
      dataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'data' field has an active Builder instance
     * @return True if the 'data' field has an active Builder instance
     */
    public boolean hasDataBuilder() {
      return dataBuilder != null;
    }

    /**
      * Clears the value of the 'data' field.
      * @return This builder.
      */
    public org.example.events.OrderEvent.Builder clearData() {
      data = null;
      dataBuilder = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderEvent build() {
      try {
        OrderEvent record = new OrderEvent();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.source = fieldSetFlags()[1] ? this.source : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.specversion = fieldSetFlags()[2] ? this.specversion : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.type = fieldSetFlags()[3] ? this.type : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.datacontenttype = fieldSetFlags()[4] ? this.datacontenttype : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.dataschema = fieldSetFlags()[5] ? this.dataschema : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.subject = fieldSetFlags()[6] ? this.subject : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.time = fieldSetFlags()[7] ? this.time : (java.lang.Long) defaultValue(fields()[7]);
        if (dataBuilder != null) {
          try {
            record.data = this.dataBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("data"));
            throw e;
          }
        } else {
          record.data = fieldSetFlags()[8] ? this.data : (org.example.events.OrderEventData) defaultValue(fields()[8]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderEvent>
    READER$ = (org.apache.avro.io.DatumReader<OrderEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.source);

    out.writeString(this.specversion);

    out.writeString(this.type);

    out.writeString(this.datacontenttype);

    out.writeString(this.dataschema);

    out.writeString(this.subject);

    out.writeLong(this.time);

    this.data.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      this.source = in.readString(this.source instanceof Utf8 ? (Utf8)this.source : null);

      this.specversion = in.readString(this.specversion instanceof Utf8 ? (Utf8)this.specversion : null);

      this.type = in.readString(this.type instanceof Utf8 ? (Utf8)this.type : null);

      this.datacontenttype = in.readString(this.datacontenttype instanceof Utf8 ? (Utf8)this.datacontenttype : null);

      this.dataschema = in.readString(this.dataschema instanceof Utf8 ? (Utf8)this.dataschema : null);

      this.subject = in.readString(this.subject instanceof Utf8 ? (Utf8)this.subject : null);

      this.time = in.readLong();

      if (this.data == null) {
        this.data = new org.example.events.OrderEventData();
      }
      this.data.customDecode(in);

    } else {
      for (int i = 0; i < 9; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          this.source = in.readString(this.source instanceof Utf8 ? (Utf8)this.source : null);
          break;

        case 2:
          this.specversion = in.readString(this.specversion instanceof Utf8 ? (Utf8)this.specversion : null);
          break;

        case 3:
          this.type = in.readString(this.type instanceof Utf8 ? (Utf8)this.type : null);
          break;

        case 4:
          this.datacontenttype = in.readString(this.datacontenttype instanceof Utf8 ? (Utf8)this.datacontenttype : null);
          break;

        case 5:
          this.dataschema = in.readString(this.dataschema instanceof Utf8 ? (Utf8)this.dataschema : null);
          break;

        case 6:
          this.subject = in.readString(this.subject instanceof Utf8 ? (Utf8)this.subject : null);
          break;

        case 7:
          this.time = in.readLong();
          break;

        case 8:
          if (this.data == null) {
            this.data = new org.example.events.OrderEventData();
          }
          this.data.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









