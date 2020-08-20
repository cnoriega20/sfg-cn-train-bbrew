package msvc.training.sfgcntrainbbrew.controller;

import msvc.training.sfgcntrainbbrew.model.Beer;
import msvc.training.sfgcntrainbbrew.model.Customer;
import msvc.training.sfgcntrainbbrew.service.BeerService;
import msvc.training.sfgcntrainbbrew.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/vi/customerService")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

       /* online UUID generator: https://www.uuidgenerator.net/
       * http://localhost:8080/api/vi/customerService/70736582-9521-41b4-8b54-a7a9086b8b5d
       * */
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getBeer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
}
