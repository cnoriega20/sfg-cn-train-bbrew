package msvc.training.sfgcntrainbbrew.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
    @Autowired
    ObjectMapper objectMapper;

    Beer getBeer(){
        return Beer.builder()
                .id(UUID.randomUUID())
                .beerName("Heineken")
                .beerStyle("Pilsner")
                .price(new BigDecimal(5.00))
                .upc(123456L)
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .build();
    }

}
