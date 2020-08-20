package msvc.training.sfgcntrainbbrew.service;

import lombok.extern.slf4j.Slf4j;
import msvc.training.sfgcntrainbbrew.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID beerId) {
        log.debug("Get a beer...");
        return Beer.builder().id(UUID.randomUUID())
                .beerName("Coors")
                .beerStyle("Pilsener")
                .build();
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        log.debug("Saving a beer...");
        return Beer.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, Beer beer) {
        //TODO: Add a real Impl with persistent data
        log.debug("Updating a beer...");
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer...");
    }
}
