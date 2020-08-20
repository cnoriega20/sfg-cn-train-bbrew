package msvc.training.sfgcntrainbbrew.service;

import msvc.training.sfgcntrainbbrew.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID beerId) {
        return Beer.builder().id(UUID.randomUUID())
                .beerName("Coors")
                .beerStyle("Pilsener")
                .build();
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        return Beer.builder()
                .id(UUID.randomUUID())
                .build();
    }
}
