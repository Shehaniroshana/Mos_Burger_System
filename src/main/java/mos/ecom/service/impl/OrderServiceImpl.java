package mos.ecom.service.impl;

import aj.org.objectweb.asm.commons.Remapper;
import lombok.RequiredArgsConstructor;
import mos.ecom.dto.Order;
import mos.ecom.entity.CustomerEntity;
import mos.ecom.entity.ItemEntity;
import mos.ecom.entity.OrderEntity;
import mos.ecom.repository.CustomerRepository;
import mos.ecom.repository.ItemRepository;
import mos.ecom.repository.OrderRepository;
import mos.ecom.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final OrderRepository repository;
    final ItemRepository itemRepository;
    final CustomerRepository customerRepository;
    final ModelMapper mapper;

    @Override
    public void addOrder(List<Order> orders) {
        for (Order order : orders) {
            repository.save(mapper.map(order, OrderEntity.class));

            Optional<ItemEntity> byId = itemRepository.findById(order.getItemId());
            if (byId.isPresent()) {
                ItemEntity item = byId.get();
                item.setQty(item.getQty() - order.getQty());
                itemRepository.save(item);
            } else {
                System.out.println("Item not found: " + order.getItemId());
            }
        }

        Integer loyaltyPoints = orders.size() * 10;

        Optional<CustomerEntity> customerById = customerRepository.findById(orders.get(0).getCustomerId());
        if (customerById.isPresent()) {
            CustomerEntity customer = customerById.get();
            Integer currentLoyaltyPoints = customer.getLoyaltyPoints() != null ? customer.getLoyaltyPoints() : 0;
            customer.setLoyaltyPoints(currentLoyaltyPoints + loyaltyPoints);
            customerRepository.save(customer);
        } else {
            System.out.println("Customer not found: " + orders.get(0).getCustomerId());
        }
    }


    @Override
    public void updateOrderStatus(Order order) {
       repository.save(mapper.map(order, OrderEntity.class));
    }

    @Override
    public void deleteOrder(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Order searchById(Integer id) {
        return mapper.map(repository.findById(id),Order.class);
    }

    @Override
    public List<Order> searchByCustomerName(String name) {
        List<CustomerEntity> byName = customerRepository.findByName(name);
        if (byName.isEmpty()) {
            return new ArrayList<>();
        }
        Optional<OrderEntity> byId = repository.findById(byName.get(0).getId());
        return List.of(mapper.map(byId.get(), Order.class));
    }

    @Override
    public List<Order> searchByItemCode(String code) {
        List<ItemEntity> byCode = itemRepository.findByCode(code);
        if (byCode.isEmpty()) {
            return new ArrayList<>();
        }

        List<OrderEntity> byItemId = repository.findByItemId(byCode.get(0).getId());
        List<Order> list = new ArrayList<>();
        byItemId.forEach(orderEntity -> list.add(mapper.map(orderEntity, Order.class)));

        return list.isEmpty() ? null : list;
    }

    @Override
    public List<Object[]> getAll() {
        Iterable<OrderEntity> all = repository.findAll();
        List<OrderEntity> list = new ArrayList<>();
        all.forEach(list::add);

        List<Object[]> result = new ArrayList<>();

        for (OrderEntity order : list) {
            boolean found = false;

            for (Object[] entry : result) {
                if (entry[0].equals(order.getCustomerId()) && entry[1].equals(order.getOrderDate()) && entry[2].equals(order.getStatus())) {
                    entry[3] = (Double) entry[3] + order.getTotalAmount();
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add(new Object[] { order.getCustomerId(), order.getOrderDate(), order.getStatus(), order.getTotalAmount() });
            }
        }

        return result;
    }

    @Override
    public void updateStatusByCustomerId(int customerId, String status) {
        repository.updateStatusByCustomerId(customerId,status);
    }

    @Override
    public void deleteByCustomerIdAndOrderDate(int customerId, String orderDate) {
        repository.deleteByCustomerIdAndOrderDate(customerId,orderDate);
    }

}
