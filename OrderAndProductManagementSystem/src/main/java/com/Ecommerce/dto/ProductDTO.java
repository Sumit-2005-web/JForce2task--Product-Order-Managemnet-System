package com.Ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @Min(value = 1, message = "Price should be greater than 0")
    private Double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

}
