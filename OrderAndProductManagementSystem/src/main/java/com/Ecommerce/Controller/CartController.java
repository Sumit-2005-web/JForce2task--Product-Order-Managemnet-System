package com.Ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ecommerce.Entity.User;
import com.Ecommerce.Service.CartService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String viewCart(Model model,
                           HttpSession session) {

        User user =
                (User) session.getAttribute("loggedInUser");

        model.addAttribute("cart",
                cartService.getCart(user.getId()));

        return "user/cart";
    }

    @PostMapping("/items")
    public String addToCart(
            @RequestParam Long productId,
            @RequestParam Integer quantity,
            HttpSession session) {

        User user =
                (User) session.getAttribute("loggedInUser");

        cartService.addToCart(
                user.getId(),
                productId,
                quantity);

        return "redirect:/products";
    }

    @PutMapping("/items/{id}")
    public String updateQuantity(
            @PathVariable Long id,
            @RequestParam Integer quantity) {

        cartService.updateCartItem(id,
                quantity);

        return "redirect:/cart";
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(
            @PathVariable Long id) {

        cartService.removeItem(id);

        return "redirect:/cart";
    }
}
