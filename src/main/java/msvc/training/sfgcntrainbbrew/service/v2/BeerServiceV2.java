package msvc.training.sfgcntrainbbrew.service.v2;

import msvc.training.sfgcntrainbbrew.model.v2.BeerV2;

import java.util.UUID;


public interface BeerServiceV2 {
    BeerV2 getBeerById(UUID beerId);

    BeerV2 saveNewBeer(BeerV2 beer);

    void updateBeer(UUID beerId, BeerV2 beer);

    void deleteById(UUID beerId);
}
