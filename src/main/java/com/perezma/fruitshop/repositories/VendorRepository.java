package com.perezma.fruitshop.repositories;

import com.perezma.fruitshop.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
