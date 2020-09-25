package msvc.training.sfgcntrainbbrew.helpers.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class CustomSerializer extends JsonSerializer<OffsetDateTime> {

    private DateTimeFormatter dateTimeFormatter;

    public CustomSerializer() {
        dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd HH:mm:ss")
                .optionalStart().appendFraction(ChronoField.NANO_OF_SECOND,
                        0, 9, true)
                .optionalEnd()
                .appendPattern("x")
                .toFormatter();

    }

    @Override
    public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(offsetDateTime.format(this.dateTimeFormatter));
    }
}
