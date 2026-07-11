package com.Ecommerce.Service;

import com.Ecommerce.Entity.Cart;

public interface CartService {

    Cart getCart(Long userId);

    void addToCart(Long userId,Long productId, Integer quantity);

    void updateCartItem(Long cartItemId, Integer quantity);

    void removeItem(Long cartItemId);

}
