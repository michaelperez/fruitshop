package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.VendorDTO;
import com.perezma.fruitshop.domain.Vendor;
import org.springframework.stereotype.Component;

@Component
public class VendorMapperImpl implements VendorMapper {
    @Override
    public VendorDTO vendorToVendorDTO(Vendor vendor) {

        if (vendor == null) {
            return null;
        }

        VendorDTO dto = new VendorDTO();
        dto.setName(vendor.getName());

        return dto;
    }

    @Override
    public Vendor vendorDTOToVendor(VendorDTO vendorDTO) {
        if (vendorDTO == null) {
            return null;
        }

        Vendor vendor = new Vendor();
        vendor.setName(vendorDTO.getName());

        return vendor;
    }
}
