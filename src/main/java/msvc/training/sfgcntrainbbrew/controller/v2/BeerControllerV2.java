package msvc.training.sfgcntrainbbrew.controller.v2;

import msvc.training.sfgcntrainbbrew.model.v2.BeerV2;
import msvc.training.sfgcntrainbbrew.service.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beerService")
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerV2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity addBeer(@RequestBody BeerV2 beer){
        BeerV2 newBeer = beerServiceV2.saveNewBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v2/beerService" + newBeer.getId().toString());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerV2 beer){
        beerServiceV2.updateBeer(beerId, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }

}
