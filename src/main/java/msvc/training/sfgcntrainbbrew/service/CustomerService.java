package msvc.training.sfgcntrainbbrew.service;

import msvc.training.sfgcntrainbbrew.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID customerId);

    Customer saveCustomer(Customer customer);

    void updateCustomer(UUID customerId, Customer customer);

    void deleteById(UUID customerId);
}
