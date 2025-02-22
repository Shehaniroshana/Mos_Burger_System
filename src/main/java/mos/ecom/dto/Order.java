package mos.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private Integer id;
    private Integer customerId;
    private  Integer  itemId;
    private Integer qty;
    private double totalAmount;
    private String orderDate;
    private String status="Pending";
}
