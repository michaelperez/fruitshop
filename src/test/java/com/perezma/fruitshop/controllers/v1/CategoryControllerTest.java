package com.perezma.fruitshop.controllers.v1;

import com.perezma.fruitshop.api.v1.model.CategoryDTO;
import com.perezma.fruitshop.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

    public static final String NAME1 = "Mikey";
    public static final String NAME2 = "Ethan";

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

    }

    @Test
    public void testListCategories() throws Exception {
        CategoryDTO dto1 = new CategoryDTO();
        dto1.setId(1L);
        dto1.setName(NAME1);

        CategoryDTO dto2 = new CategoryDTO();
        dto2.setId(2L);
        dto1.setName(NAME2);

        List<CategoryDTO> categories = Arrays.asList(dto1, dto2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get(CategoryController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));
    }

    @Test
    public void testGetByNameCategories() throws Exception {
        CategoryDTO dto1 = new CategoryDTO();
        dto1.setId(1l);
        dto1.setName(NAME1);

        when(categoryService.getCategoryByName(anyString())).thenReturn(dto1);

        // the url path must match mapping in controller, though name in path is not used.
        // Only dto1 is returned and tested.
        mockMvc.perform(get(CategoryController.BASE_URL + "/" + NAME1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(NAME1)));
    }
}