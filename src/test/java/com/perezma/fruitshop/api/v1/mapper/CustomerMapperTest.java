package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.CustomerDTO;
import com.perezma.fruitshop.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    public static final long ID = 1L;
    public static final String FIRST_NAME = "Tyrion";
    public static final String LAST_NAME = "Lannister";

    CustomerMapper customerMapper = new CustomerMapperImpl();

    @Test
    public void customerToCustomerDTO() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);

        //when
        CustomerDTO dto = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRST_NAME, dto.getFirstName());
        assertEquals(LAST_NAME, dto.getLastName());

    }
}