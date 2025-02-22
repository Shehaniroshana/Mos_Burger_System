package mos.ecom.repository;

import jakarta.transaction.Transactional;
import mos.ecom.entity.OrderEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

    // Assuming orders can have multiple items, the method name could be modified accordingly
    List<OrderEntity> findByItemId(Integer itemId);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o SET o.status = :status WHERE o.customerId = :customerId")
    void updateStatusByCustomerId(int customerId, String status);
    @Modifying
    @Transactional
    @Query("DELETE FROM OrderEntity o WHERE o.customerId = :customerId AND o.orderDate = :orderDate")
    void deleteByCustomerIdAndOrderDate(int customerId, String orderDate);
}
