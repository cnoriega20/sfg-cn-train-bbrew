package msvc.training.sfgcntrainbbrew.service;

import msvc.training.sfgcntrainbbrew.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID beerId);
}
