package msvc.training.sfgcntrainbbrew.mappers;

import msvc.training.sfgcntrainbbrew.domain.CustomerEntity;
import msvc.training.sfgcntrainbbrew.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerEntity mapCustomerToCustomerEntity(Customer customer);

    Customer mapCustomerEntityToCustomer(CustomerEntity customerEntity);
}
