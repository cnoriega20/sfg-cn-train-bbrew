package msvc.training.sfgcntrainbbrew.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("snake")
@Slf4j
public class BeerSnakePropNameTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testBeerSnakePropertyName() throws JsonProcessingException {
        Beer beer = getBeer();
        String json = objectMapper.writeValueAsString(beer);
        log.info("Beer with Snake PropertyNamingStrategy: " + json);
    }
}
