package mos.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private Integer id;
    private String name;
    private String contact;
    private Integer loyaltyPoints;
}
