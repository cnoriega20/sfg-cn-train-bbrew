package msvc.training.sfgcntrainbbrew.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;

}
