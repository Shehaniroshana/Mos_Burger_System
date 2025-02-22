package mos.ecom.controller;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.Items;
import mos.ecom.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ItemController {
    final ItemService service;

    @PostMapping("/save_item")
    public void saveItem(@RequestBody Items items) {
        service.addItem(items);
    }

    @PutMapping("/update_item")
    public void updateItem(@RequestBody Items items) {
        service.updateItem(items);
    }

    @DeleteMapping("/delete_item/{id}")
    public void deleteItem(@PathVariable Integer id) {
        service.deleteItem(id);
    }

    @GetMapping("/item_search_by_id/{id}")
    public Items searchById(@PathVariable Integer id) {
        return service.searchById(id);
    }

    @GetMapping("/item_search_by_name/{name}")
    public List<Items> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }

    @GetMapping("/get_all_items")
    public List<Items> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/get_items_by_category/{category}")
    public List<Items> findByCategory(@PathVariable String category) {
        return service.findByCategory(category);
    }

}
