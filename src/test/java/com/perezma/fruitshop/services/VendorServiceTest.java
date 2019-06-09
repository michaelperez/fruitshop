package com.perezma.fruitshop.services;

import com.perezma.fruitshop.api.v1.mapper.VendorMapperImpl;
import com.perezma.fruitshop.api.v1.model.VendorDTO;
import com.perezma.fruitshop.api.v1.model.VendorListDTO;
import com.perezma.fruitshop.domain.Vendor;
import com.perezma.fruitshop.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class VendorServiceTest {

    public static final long ID_1 = 1L;
    public static final String NAME_1 = "High Garden Estates";
    public static final long ID_2 = 2L;
    public static final String NAME_2 = "River Run Excursions";

    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(new VendorMapperImpl(), vendorRepository);
    }

    @Test
    public void getAllVendors() {
        //given
        List<Vendor> vendors = Arrays.asList(getVendor1(), getVendor2());

        //Mockito BDD syntax
        given(vendorRepository.findAll()).willReturn(vendors);

        //when
        VendorListDTO vendorListDTO = vendorService.getAllVendors();

        //then
        then(vendorRepository).should(times( 1)).findAll();

        //JUnit AssertThat with matchers
        assertThat(vendorListDTO.getVendors().size(), is(equalTo(2)));
    }

    @Test
    public void getVendorById() {
        //given
        Vendor vendor = getVendor1();
        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        //when
        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        //then
        then(vendorRepository).should(times(1)).findById(anyLong());
        assertThat(vendorDTO.getName(), is(equalTo(NAME_1)));
    }

    @Test
    public void createNewVendor() throws Exception {

        //given
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME_1);

        Vendor vendor = getVendor1();

        given(vendorRepository.save(any(Vendor.class))).willReturn(vendor);

        //when
        VendorDTO savedVendorDTO = vendorService.createNewVendor(vendorDTO);

        //then
        // 'should' defaults to times = 1
        then(vendorRepository).should().save(any(Vendor.class));
        assertThat(savedVendorDTO.getVendorUrl(), containsString("1"));

    }

    @Test
    public void saveVendorById() {
    }

    @Test
    public void patchVendor() {
    }

    @Test
    public void deleteVendorById() {
    }

    private Vendor getVendor1() {
        Vendor vendor = new Vendor();
        vendor.setId(ID_1);
        vendor.setName(NAME_1);
        return vendor;
    }

    private Vendor getVendor2() {
        Vendor vendor = new Vendor();
        vendor.setId(ID_2);
        vendor.setName(NAME_2);
        return vendor;
    }
}