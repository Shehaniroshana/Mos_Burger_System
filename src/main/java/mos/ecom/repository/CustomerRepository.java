package mos.ecom.repository;

import mos.ecom.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Integer> {
    List<CustomerEntity> findByName(String name);
    List<CustomerEntity> findByContact(String contact);
}
