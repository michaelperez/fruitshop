package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.VendorDTO;
import com.perezma.fruitshop.domain.Vendor;

public interface VendorMapper {

    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}
