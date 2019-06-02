package com.perezma.fruitshop.controllers.v1;

import com.perezma.fruitshop.api.v1.model.CustomerDTO;
import com.perezma.fruitshop.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testListCustomers() throws Exception {
        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setFirstName("Tyrion");
        customer1.setLastName("Lannister");
        customer1.setCustomerUrl("/api/v1/customer/1");

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setFirstName("Cersei");
        customer2.setLastName("Lannister");
        customer2.setCustomerUrl("/api/v1/customer/2");

        CustomerDTO customer3 = new CustomerDTO();
        customer3.setFirstName("Jamie");
        customer3.setLastName("Lannister");
        customer3.setCustomerUrl("/api/v1/customer/3");

        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer1, customer2, customer3));

        mockMvc.perform(get("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(3)));
    }

    @Test
    public void testGetCustomerById() throws Exception {
        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setFirstName("Brienne");
        customer1.setLastName("Tarth");
        customer1.setCustomerUrl("/api/v1/customers/1");

        when(customerService.getCustomerById(anyLong())).thenReturn(customer1);

        //when
        mockMvc.perform(get("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo("Brienne")));
    }

}