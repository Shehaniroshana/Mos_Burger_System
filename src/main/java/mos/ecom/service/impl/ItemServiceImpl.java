package mos.ecom.service.impl;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.Items;
import mos.ecom.entity.ItemEntity;
import mos.ecom.repository.ItemRepository;
import mos.ecom.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    final ItemRepository repository;
    final ModelMapper mapper;
    @Override
    public void addItem(Items items) {
       repository.save(mapper.map(items, ItemEntity.class));
    }

    @Override
    public void updateItem(Items items) {
       repository.save(mapper.map(items, ItemEntity.class));
    }

    @Override
    public void deleteItem(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Items searchById(Integer id) {
        return mapper.map(repository.findById(id), Items.class);
    }

    @Override
    public List<Items> searchByName(String name) {
        List<ItemEntity> byName = repository.findByName(name);
        List<Items> list=new ArrayList<>();
        byName.forEach(itemEntity -> {
            list.add(mapper.map(itemEntity, Items.class));
        });
        return list;
    }


    @Override
    public List<Items> getAllItems() {
        Iterable<ItemEntity> all = repository.findAll();
        List<Items> list=new ArrayList<>();
        all.forEach(itemEntity -> {
            list.add(mapper.map(itemEntity, Items.class));
        });
        return list;
    }

    @Override
    public List<Items> findByCategory(String category) {
        List<ItemEntity> allByCategory = repository.findAllByCategory(category);
        List<Items> list=new ArrayList<>();
        allByCategory.forEach(itemEntity -> {
            list.add(mapper.map(itemEntity, Items.class));
        });
        return list;
    }
}
