package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.VendorDTO;
import com.perezma.fruitshop.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendorMapperTest {

    public static final long ID = 1L;
    public static final String NAME = "High Garden Estates";

    VendorMapper vendorMapper = new VendorMapperImpl();

    @Test
    public void vendorToVendorDTO() throws Exception {

        //given
        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        //when
        VendorDTO dto = vendorMapper.vendorToVendorDTO(vendor);

        //then
        assertEquals(NAME, dto.getName());
    }

    @Test
    public void vendorDTOToVendor() throws Exception {

        //given
        VendorDTO dto = new VendorDTO();
        dto.setName(NAME);

        //when
        Vendor vendor = vendorMapper.vendorDTOToVendor(dto);

        //then
        assertEquals(NAME, vendor.getName());
    }
}