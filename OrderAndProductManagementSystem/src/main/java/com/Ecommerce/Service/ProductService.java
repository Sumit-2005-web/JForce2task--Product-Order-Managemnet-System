package com.Ecommerce.Service;

import java.util.List;

import com.Ecommerce.Entity.Product;
import com.Ecommerce.dto.ProductDTO;

public interface ProductService {

    Product save(ProductDTO dto);

//    Product update(Long id, ProductDTO dto);

    void disable(Long id);

    void enable(Long id);

    List<Product> getAllProducts();

    List<Product> getAvailableProducts();

    Product getById(Long id);
    
    Product update(Long id, Product product);

}
