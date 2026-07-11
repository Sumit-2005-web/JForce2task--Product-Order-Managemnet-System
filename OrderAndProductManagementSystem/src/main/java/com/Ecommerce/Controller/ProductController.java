package com.Ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.Entity.User;
import com.Ecommerce.Service.ProductService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String products(Model model,
                           HttpSession session) {

        User user =
                (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);

        model.addAttribute("products",
                productService.getAvailableProducts());

        return "user/dashboard";
    }
}
