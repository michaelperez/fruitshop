package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.CustomerDTO;
import com.perezma.fruitshop.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {

        if (customer == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());

        return customerDTO;
    }
}
