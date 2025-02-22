package mos.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Items {
    private Integer id;
    private String code;
    private String name;
    private String category;
    private Integer qty;
    private Double price;
    private Double discount=0.0;
}
