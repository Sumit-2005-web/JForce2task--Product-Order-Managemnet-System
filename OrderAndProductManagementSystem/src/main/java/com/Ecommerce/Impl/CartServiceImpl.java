package com.Ecommerce.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.Ecommerce.Entity.Cart;
import com.Ecommerce.Entity.CartItem;
import com.Ecommerce.Entity.Product;
import com.Ecommerce.Entity.User;
import com.Ecommerce.Exception.ResourceNotFoundException;
import com.Ecommerce.Repository.CartItemRepository;
import com.Ecommerce.Repository.CartRepository;
import com.Ecommerce.Repository.ProductRepository;
import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.Service.CartService;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Cart getCart(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Not Found"));

        return cartRepository.findByUser(user)
                .orElseGet(() -> {

                    Cart cart = new Cart();
                    cart.setUser(user);

                    return cartRepository.save(cart);
                });
    }

    @Override
    public void addToCart(Long userId,
                          Long productId,
                          Integer quantity) {

        Cart cart = getCart(userId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product Not Found"));

        CartItem item = cartItemRepository
                .findByCartAndProduct(cart, product)
                .orElse(null);

        if(item == null){

            item = new CartItem();

            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(quantity);

        }else{

            item.setQuantity(item.getQuantity() + quantity);
        }

        cartItemRepository.save(item);
    }

    @Override
    public void updateCartItem(Long cartItemId,
                               Integer quantity) {

        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart Item Not Found"));

        item.setQuantity(quantity);

        cartItemRepository.save(item);
    }

    @Override
    public void removeItem(Long cartItemId) {

        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart Item Not Found"));

        cartItemRepository.delete(item);
    }
}