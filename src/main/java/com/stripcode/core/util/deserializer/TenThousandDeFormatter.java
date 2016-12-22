package com.stripcode.core.util.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by Metro on 2016/10/21.
 */
public class TenThousandDeFormatter extends JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
       String value = jsonParser.getText();
        if(StringUtils.isBlank(value)){
                return null;
        }
        return Double.parseDouble(value) * 10000;
    }
}
