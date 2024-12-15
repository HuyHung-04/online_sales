package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "order_id phai > 0")
    private Long orderId;

    @JsonProperty("product_id")
    @Min(value = 1, message = "product_id phai > 0")
    private Long productId;

    @Min(value = 0, message = "Gia phai > || = 0")
    private Long price;

    @Min(value = 1, message = "number_of_products phai > 0")
    @JsonProperty("number_of_products")
    private int numberOfProducts;

    @Min(value = 0, message = "total_money phai > 0")
    @JsonProperty("total_money")
    private int totalMoney;

    private String color;
}
