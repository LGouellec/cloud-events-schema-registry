# Cloud Events Schema Registry example

## Cloud Events spec

The following table shows exemplary mappings:

| CloudEvents     | Type   | Exemplary Avro Value                      |
|-----------------|--------|-------------------------------------------|
| id              | string | `7a0dc520-c870-4193c8`                    |
| source          | string | `kafka`          |
| specversion     | string | `1.0`                                     |
| type            | string | `org.example.events.OrderEvent`           |
| datacontenttype | string | `application/octet-stream`                |
| dataschema      | string | `http://localhost:8081/subjects/orders-value/versions` |
| subject         | string | `orders-value`                           |
| time            | long   | `application/octet-stream`                    |
| data            | bytes  | `Order Event Json Object`                                 |

## Confluent platform version

This example run with the docker image version `7.6.0.arm64`. Feel free to udpate the `.env` file before starting the demo with `./start.sh`. 

# How to start ? 

You can run the script `./start.sh` which will deploy all the docker stacks, a simple JAVA producer and start a console consumer to consume the messages from the `orders` topic.

## Order Event spec

Please find bellow the full Avro schema which contains the Cloud Event spec + the Order Event data. The Kafka Producer must send an message corresponding this JSON schema. 

The [Cloud Event SDK](https://cloudevents.github.io/sdk-java/api.html) support only data as a byte array. Unfortunaly, Kafka and the Schema Registry can't enforce a schema with a data already serilized as a byte array.
So the best option is to enforce a schema based on the cloud event specs without using the `cloud event java SDK`. 

``` 
{
  "namespace":"org.example.events",
  "type":"record",
  "name":"OrderEvent",
  "version":"1.0",
  "doc":"Order event avro format",
  "fields":[
    {
      "name":"id",
      "type": "string"
    },
    {
      "name":"source",
      "type": "string"
    },
    {
      "name":"specversion",
      "type": "string"
    },
    {
      "name":"type",
      "type": "string"
    },
    {
      "name":"datacontenttype",
      "type": "string"
    },
    {
      "name":"dataschema",
      "type": "string"
    },
    {
      "name":"subject",
      "type": "string"
    },
    {
      "name":"time",
      "type": "long"
    },
    {
      "name": "data",
      "type": {
        "type": "record",
        "name": "OrderEventData",
        "fields": [
          {
            "name": "orderId",
            "type": "long"
          },
          {
            "name": "productId",
            "type": "string"
          },
          {
            "name": "userId",
            "type": "string"
          },
          {
            "name": "quantity",
            "type": "long"
          }
        ]
      }
    }
  ]
}
```

In your JAVA code, you must create a bean and set all the cloud events metadata + your bean object
 
``` java
OrderEvent event = new OrderEvent();
event.setId(UUID.randomUUID().toString());
event.setTime(System.currentTimeMillis());
event.setType("org.example.events.OrderEvent");
event.setSubject("orders-value");
event.setDataschema("http://localhost:8081/subjects/orders-value/versions");
event.setSpecversion("1.0");
event.setDatacontenttype("application/octet-stream");
event.setSource("kafka");

event.setData(
    new OrderEventData(
        ++orderId,
        UUID.randomUUID().toString(),
        "User:"+UUID.randomUUID().toString(),
        (long)rd.nextInt(10) + 1));
```

Finally you can use the Kafka Avro Serilizer which interact with the schema registry to validate the bean with the schema

``` java
producerConf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
producerConf.put(KafkaAvroSerializerConfig.AUTO_REGISTER_SCHEMAS, "true");
producerConf.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
```

If you consume the output topic, the console consumer should be able to read your messages :

``` logs
{"id":"7e7a421a-71bc-486d-92cc-b75fb506e2b8","source":"kafka","specversion":"1.0","type":"org.example.events.OrderEvent","datacontenttype":"application/octet-stream","dataschema":"http://localhost:8081/subjects/orders-value/versions","subject":"orders-value","time":1709118147759,"data":{"orderId":36,"productId":"e6d97f74-523d-49ec-bf6a-e818a8878a37","userId":"User:61ba0e74-f314-4ac1-8a54-438c5a1d3ad7","quantity":10}}
{"id":"8b0d853b-2425-4b45-85e3-d8d30dc50fda","source":"kafka","specversion":"1.0","type":"org.example.events.OrderEvent","datacontenttype":"application/octet-stream","dataschema":"http://localhost:8081/subjects/orders-value/versions","subject":"orders-value","time":1709118148265,"data":{"orderId":37,"productId":"6c6f5786-32e1-421d-8e80-c4ba43c4def2","userId":"User:ff03aa36-02cb-45b2-864a-8c43bfba56be","quantity":9}}
{"id":"0cc2be26-d5f8-484d-8c89-6136e911cb09","source":"kafka","specversion":"1.0","type":"org.example.events.OrderEvent","datacontenttype":"application/octet-stream","dataschema":"http://localhost:8081/subjects/orders-value/versions","subject":"orders-value","time":1709118148770,"data":{"orderId":38,"productId":"f39a4495-f8ca-48b1-91c7-26a73c2207c0","userId":"User:e5950439-b389-4f4a-86bf-2243627f2db1","quantity":6}}
...
```