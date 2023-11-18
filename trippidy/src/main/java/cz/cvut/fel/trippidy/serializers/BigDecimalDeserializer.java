package cz.cvut.fel.trippidy.serializers;

import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.stream.JsonParser;
import java.math.BigDecimal;
import java.lang.reflect.Type;

public class BigDecimalDeserializer implements JsonbDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        return new BigDecimal(parser.getString());
    }
}
