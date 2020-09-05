package msvc.training.sfgcntrainbbrew.controller;

import msvc.training.sfgcntrainbbrew.model.Customer;
import msvc.training.sfgcntrainbbrew.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customerService")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

       /* online UUID generator: https://www.uuidgenerator.net/
       * http://localhost:8080/api/v1/customerService/70736582-9521-41b4-8b54-a7a9086b8b5d
       * */
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getBeer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping // POST - create new customer
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        Customer newCustomer = customerService.saveCustomer(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customerService" + newCustomer.getId().toString());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @Valid @RequestBody Customer customer){
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }

}
