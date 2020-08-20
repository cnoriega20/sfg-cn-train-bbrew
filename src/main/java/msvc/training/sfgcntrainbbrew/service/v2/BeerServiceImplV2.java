package msvc.training.sfgcntrainbbrew.service.v2;

import lombok.extern.slf4j.Slf4j;
import msvc.training.sfgcntrainbbrew.model.v2.BeerStyleEnum;
import msvc.training.sfgcntrainbbrew.model.v2.BeerV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2{
    @Override
    public BeerV2 getBeerById(UUID beerId) {
        log.debug("Get a beer...");
        return BeerV2.builder().id(UUID.randomUUID())
                .beerName("Miller")
                .beerStyle(BeerStyleEnum.PILSENER)
                .build();
    }

    @Override
    public BeerV2 saveNewBeer(BeerV2 beer) {
        log.debug("Saving a beer...");
        return BeerV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerV2 beer) {

    }

    @Override
    public void deleteById(UUID beerId) {

    }
}
