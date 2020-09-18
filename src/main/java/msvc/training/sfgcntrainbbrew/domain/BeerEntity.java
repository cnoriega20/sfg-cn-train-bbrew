package msvc.training.sfgcntrainbbrew.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerEntity {

    private UUID id;


    private String beerName;


    private String beerStyle;


    private Long upc;

    private Timestamp createdDate;

    private Timestamp lastUpdatedDate;
}
