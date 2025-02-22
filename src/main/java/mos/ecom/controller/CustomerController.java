package mos.ecom.controller;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.Customer;
import mos.ecom.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mos")
@CrossOrigin(origins = "*")
public class CustomerController {

    final CustomerService service;

    @PostMapping("/save_customer")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @PutMapping("/update_customer")
    public void updateCustomer(@RequestBody Customer customer) {
        service.updateCustomer(customer);
    }

    @DeleteMapping("/delete_customer/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return service.getAll();
    }

    @GetMapping("/search_by_id/{id}")
    public Customer searchById(@PathVariable Integer id) {
        return service.searchById(id);
    }

    @GetMapping("/search_by_name/{name}")
    public List<Customer> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }

    @GetMapping("/search_by_contact/{contact}")
    public List<Customer> searchByContact(@PathVariable String contact) {
        return service.searchByContact(contact);
    }

    @GetMapping("/get_all_customer_ids")
    public List<Integer> getAllCustomerIds(){
        return service.getAllCustomerId();
    }
}
