package cz.cvut.fel.trippidy.serializers;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;
import java.math.BigDecimal;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class BigDecimalSerializer implements JsonbSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.toString());
    }
}