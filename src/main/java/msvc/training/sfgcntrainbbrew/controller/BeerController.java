package msvc.training.sfgcntrainbbrew.controller;

import msvc.training.sfgcntrainbbrew.model.Beer;
import msvc.training.sfgcntrainbbrew.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/vi/beerService")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

       /* online UUID generator: https://www.uuidgenerator.net/
       * http://localhost:8080/api/vi/beerService/70736582-9521-41b4-8b54-a7a9086b8b5d
       * */
    @GetMapping("/{beerId}")
    public ResponseEntity<Beer> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new beer
    public ResponseEntity addBeer(Beer beer){
        Beer newBeer = beerService.saveNewBeer(beer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/vi/beerService" + newBeer.getId().toString());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

}
