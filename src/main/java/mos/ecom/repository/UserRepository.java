package mos.ecom.repository;

import mos.ecom.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
   public UserEntity findByNameAndPassword(String name, String password);
}
