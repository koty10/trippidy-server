package cz.cvut.fel.trippidy.serializers;

import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;
import java.lang.reflect.Type;
import java.math.BigDecimal;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

public class BigDecimalSerializer implements JsonbSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.toString());
    }
}
