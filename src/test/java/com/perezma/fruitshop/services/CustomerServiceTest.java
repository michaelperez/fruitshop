package com.perezma.fruitshop.services;

import com.perezma.fruitshop.api.v1.mapper.CustomerMapperImpl;
import com.perezma.fruitshop.api.v1.model.CustomerDTO;
import com.perezma.fruitshop.domain.Customer;
import com.perezma.fruitshop.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    public final static Long ID1 = 1L;
    public final static String FIRST_NAME1 = "Sansa";
    public final static String LAST_NAME1 = "Stark";

    public final static Long ID2 = 2L;
    public final static String FIRST_NAME2 = "Arya";
    public final static String LAST_NAME2 = "Stark";

    CustomerService service;

    @Mock
    CustomerRepository repository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new CustomerServiceImpl(new CustomerMapperImpl(), repository);
    }

    @Test
    public void getAllCustomers() {

        //given
        Customer customer1 = new Customer();
        customer1.setId(ID1);
        customer1.setFirstName(FIRST_NAME1);
        customer1.setLastName(LAST_NAME1);

        Customer customer2 = new Customer();
        customer2.setId(ID2);
        customer2.setFirstName(FIRST_NAME2);
        customer2.setLastName(LAST_NAME2);

        when(repository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        //when
        List<CustomerDTO> dtos = service.getAllCustomers();

        //then
        assertEquals(2, dtos.size());

    }

    @Test
    public void getCustomerById() {

        //given
        Customer customer1 = new Customer();
        customer1.setId(ID1);
        customer1.setFirstName(FIRST_NAME1);
        customer1.setLastName(LAST_NAME1);

        when(repository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDTO dto = service.getCustomerById(ID1);

        //then
        assertEquals(FIRST_NAME1, dto.getFirstName());
        assertEquals(LAST_NAME1, dto.getLastName());

    }
}