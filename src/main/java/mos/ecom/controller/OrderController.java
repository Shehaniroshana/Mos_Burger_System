package mos.ecom.controller;

import lombok.RequiredArgsConstructor;
import mos.ecom.dto.Order;
import mos.ecom.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mos")
@CrossOrigin
public class OrderController {
    final OrderService service;

    @PostMapping("/save_order")
    public void saveData(@RequestBody List<Order> order){
       service.addOrder(order);
    }

    @PostMapping("/update_order")
    public void updateData(@RequestBody Order order){
        service.updateOrderStatus(order);
    }

    @DeleteMapping("/delete_order/{id}")
    public void deleteData(@PathVariable Integer id){
        service.deleteOrder(id);
    }

    @GetMapping("/get_all_orders")
    public List<Object[]> getAllOrders(){
        return service.getAll();
    }

    @GetMapping("/order_search_by_id/{id}")
    public Order searchById(@PathVariable Integer id){
        return service.searchById(id);
    }

    @GetMapping("/order_search_by_customer_name/{name}")
    public List<Order> searchByCustomerName(@PathVariable String name){
        return service.searchByCustomerName(name);
    }

    @GetMapping("/order_search_by_item_code/{code}")
    public List<Order> searchByItemCode(@PathVariable String code){
        return service.searchByItemCode(code);
    }

    @PutMapping("/update_by_customerId/{id}/{status}")
    public void updateByCustomerId( @PathVariable Integer id,@PathVariable String status){
        service.updateStatusByCustomerId(id,status);
    }

    @DeleteMapping("delete_by_customer_id/{customerId}/{orderDate}")
    void deleteByCustomerIdAndOrderDate(@PathVariable Integer customerId,@PathVariable String orderDate){
      service.deleteByCustomerIdAndOrderDate(customerId,orderDate);
    }

}
