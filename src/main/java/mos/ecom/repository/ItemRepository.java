package mos.ecom.repository;

import mos.ecom.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
    public List<ItemEntity> findByName(String name);
    List<ItemEntity> findAllByCategory(String category);
    List<ItemEntity> findByCode(String code);
}
