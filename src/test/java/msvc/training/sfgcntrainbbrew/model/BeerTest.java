package msvc.training.sfgcntrainbbrew.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
@Slf4j
public class BeerTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerialize() throws JsonProcessingException {
        Beer beer = getBeer();
        String jsonToString = objectMapper.writeValueAsString(beer);
        log.info("Serialized beer: " + jsonToString);
    }

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json = "{\"id\":\"44b5f636-7d09-42ad-9f90-1a6da57d6a51\",\"beerName\":\"Heineken\",\"beerStyle\":\"Pilsner\",\"upc\":123456,\"price\":5,\"createdDate\":\"2020-09-24T15:50:40.7525413-05:00\",\"lastUpdatedDate\":\"2020-09-24T15:50:40.7535451-05:00\"}";
        Beer beer = objectMapper.readValue(json, Beer.class);
        log.info("Deserialized beer: " + beer);
    }

}