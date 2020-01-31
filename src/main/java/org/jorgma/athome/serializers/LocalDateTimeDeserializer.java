package org.jorgma.athome.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by jorgma on 2018-02-20.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {


    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String toDeserialize = jsonParser.getText();
        if(toDeserialize.length() == 20 && toDeserialize.endsWith("Z")) {
            toDeserialize = toDeserialize.substring(0,19);
        }else {
            LocalDateTime.parse(toDeserialize);
        }
        return LocalDateTime.parse(toDeserialize);
    }
}
