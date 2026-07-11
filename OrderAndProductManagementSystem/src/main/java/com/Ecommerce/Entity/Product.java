package com.Ecommerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
    
    
    @NotNull
    @DecimalMin("0.01")
    private Double price;

    @NotNull
    @Min(0)
    private Integer quantity;

    @Column(nullable = false)
    private Boolean enabled=true;
}
