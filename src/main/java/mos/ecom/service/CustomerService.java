package mos.ecom.service;

import mos.ecom.dto.Customer;

import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer id);
    List<Customer> getAll();
    Customer searchById(Integer id);
    List<Customer> searchByContact(String contact);
    List<Customer> searchByName(String name);
    List<Integer> getAllCustomerId();
}
