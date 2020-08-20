package msvc.training.sfgcntrainbbrew.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerV2 {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
}
