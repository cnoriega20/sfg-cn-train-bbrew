package msvc.training.sfgcntrainbbrew.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@JsonTest
@ActiveProfiles("kebab")
@Slf4j
public class BeerKebabPropNamTest extends BaseTest {

    @Test
    public void testBeerKebabNamePropertyStrategy() throws JsonProcessingException {
        Beer beer = getBeer();
        String json = objectMapper.writeValueAsString(beer);
        log.info("Beer with Kebab PropertyNamingStrategy: " + json);
    }
}
