package msvc.training.sfgcntrainbbrew.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("snake")
@Slf4j
public class BeerSnakePropNameTest extends BaseTest{

    @Test
    void testBeerSnakePropertyName() throws JsonProcessingException {
        Beer beer = getBeer();
        String json = objectMapper.writeValueAsString(beer);
        log.info("Beer with Snake PropertyNamingStrategy: " + json);
    }
}
