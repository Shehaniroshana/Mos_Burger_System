package mos.ecom.service.impl;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.Customer;
import mos.ecom.entity.CustomerEntity;
import mos.ecom.repository.CustomerRepository;
import mos.ecom.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository repository;
    final ModelMapper mapper;
    @Override
    public void addCustomer(Customer customer) {
      repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        Iterable<CustomerEntity> all = repository.findAll();
        List<Customer> list=new ArrayList<>();
        all.forEach(customerEntity -> {
            list.add(mapper.map(customerEntity,Customer.class));
        });
        return list;
    }

    @Override
    public Customer searchById(Integer id) {
        return mapper.map(repository.findById(id),Customer.class);
    }

    @Override
    public List<Customer> searchByContact(String contact) {
        List<CustomerEntity> byContact = repository.findByContact(contact);
        List<Customer> list=new ArrayList<>();
        byContact.forEach(customerEntity -> {
            list.add(mapper.map(customerEntity,Customer.class));
        });
        return list;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<CustomerEntity> byName = repository.findByName(name);
        List<Customer> list=new ArrayList<>();
        byName.forEach(customerEntity -> {
            list.add(mapper.map(customerEntity,Customer.class));
        });
        return list;
    }

    @Override
    public List<Integer> getAllCustomerId() {
        Iterable<CustomerEntity> all = repository.findAll();
        List<Integer> idList=new ArrayList<>();
        all.forEach(customerEntity -> {
            idList.add(customerEntity.getId());
        });
        return idList;
    }

}
