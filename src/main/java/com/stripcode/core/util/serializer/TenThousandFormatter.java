package com.stripcode.core.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Metro on 2016/10/21.
 */
public class TenThousandFormatter extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        if (value != null)
        {
            Double m = value/10000d;
            gen.writeString(m.toString());
        }
        else
        {
            gen.writeNull();
        }
    }
}
