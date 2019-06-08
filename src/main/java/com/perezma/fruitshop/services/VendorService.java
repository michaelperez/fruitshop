package com.perezma.fruitshop.services;

import com.perezma.fruitshop.api.v1.model.VendorDTO;
import com.perezma.fruitshop.domain.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAllVendors();

    Vendor getVendorById(String id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorById(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
