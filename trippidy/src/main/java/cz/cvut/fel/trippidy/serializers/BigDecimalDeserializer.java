package cz.cvut.fel.trippidy.serializers;

import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.stream.JsonParser;
import java.math.BigDecimal;
import java.lang.reflect.Type;

public class BigDecimalDeserializer implements JsonbDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        return new BigDecimal(parser.getString());
    }
}