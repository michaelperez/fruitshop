package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.CustomerDTO;
import com.perezma.fruitshop.domain.Customer;

public interface CustomerMapper {
    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
