package msvc.training.sfgcntrainbbrew.service;

import msvc.training.sfgcntrainbbrew.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID beerId);

    Beer saveNewBeer(Beer beer);

    void updateBeer(UUID beerId, Beer beer);
}
