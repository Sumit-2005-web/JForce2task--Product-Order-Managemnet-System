package com.Ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.Entity.User;
import com.Ecommerce.Service.OrderService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String orders(Model model,
                         HttpSession session) {

        User user =
                (User) session.getAttribute("loggedInUser");

        model.addAttribute("orders",
                orderService.getOrders(user.getId()));

        return "user/orders";
    }

    @PostMapping
    public String placeOrder(HttpSession session) {

        User user =
                (User) session.getAttribute("loggedInUser");

        orderService.placeOrder(user.getId());

        return "redirect:/orders";
    }
}
