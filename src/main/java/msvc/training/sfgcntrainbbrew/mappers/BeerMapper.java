package msvc.training.sfgcntrainbbrew.mappers;

import msvc.training.sfgcntrainbbrew.domain.BeerEntity;
import msvc.training.sfgcntrainbbrew.model.Beer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    Beer mapBeerEntityToBeer(BeerEntity beerEntity);

    BeerEntity mapBeerToBeerEntity(Beer beer);
}
