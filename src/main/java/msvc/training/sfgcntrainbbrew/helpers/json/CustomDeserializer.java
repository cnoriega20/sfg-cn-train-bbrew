package msvc.training.sfgcntrainbbrew.helpers.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class CustomDeserializer extends JsonDeserializer<OffsetDateTime> {

    private DateTimeFormatter dateTimeFormatter;

    public CustomDeserializer() {
       dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd HH:mm:ss")
                .optionalStart().appendFraction(ChronoField.NANO_OF_SECOND,
                        0, 9, true)
                .optionalEnd()
                .appendPattern("x")
                .toFormatter();

    }

    @Override
    public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return OffsetDateTime.parse(jsonParser.getText(), this.dateTimeFormatter);
    }
}
