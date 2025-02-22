package mos.ecom.service;

import mos.ecom.dto.Items;

import java.util.List;

public interface ItemService {
    void addItem(Items items);
    void updateItem(Items items);
    void deleteItem(Integer id);
    Items searchById(Integer id);
    List<Items> searchByName(String name);
    List<Items> getAllItems();
    List<Items> findByCategory(String category);
}
