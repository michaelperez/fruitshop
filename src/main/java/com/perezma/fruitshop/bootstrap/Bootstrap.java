package com.perezma.fruitshop.bootstrap;

import com.perezma.fruitshop.domain.Category;
import com.perezma.fruitshop.domain.Customer;
import com.perezma.fruitshop.domain.Vendor;
import com.perezma.fruitshop.repositories.CategoryRepository;
import com.perezma.fruitshop.repositories.CustomerRepository;
import com.perezma.fruitshop.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;
    VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Bootstrap data: " + categoryRepository.count() + " categories loaded.");
    }


    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Sansa");
        customer1.setLastName("Stark");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Arya");
        customer2.setLastName("Stark");

        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setFirstName("Bran");
        customer3.setLastName("Stark");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        System.out.println("Bootstrap data: " + customerRepository.count() + " customers loaded.");
    }

    private void loadVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setId(1L);
        vendor1.setName("High Garden Estates");

        Vendor vendor2 = new Vendor();
        vendor2.setId(2L);
        vendor2.setName("River Run Excursions");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);

        System.out.println("Bootstrap data: " + vendorRepository.count() + " vendors loaded.");
    }

}
