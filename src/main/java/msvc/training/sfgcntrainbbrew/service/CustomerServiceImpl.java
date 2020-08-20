package msvc.training.sfgcntrainbbrew.service;

import lombok.extern.slf4j.Slf4j;
import msvc.training.sfgcntrainbbrew.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl  implements CustomerService{

    @Override
    public Customer getCustomerById(UUID customerId) {
        log.debug("Getting a customer from service .....");
        return Customer.builder().id(UUID.randomUUID())
                .name("Frank Dux")
                .build();
    }

    @Override
    public Customer saveCustomer(@RequestBody Customer customer) {
        log.debug("Adding a customer to service .....");
        return Customer.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, @RequestBody Customer customer) {
        //TODO: Add a real Impl with persistent data
        log.debug("Updating a customer to service...");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting a customer.....");
    }
}
