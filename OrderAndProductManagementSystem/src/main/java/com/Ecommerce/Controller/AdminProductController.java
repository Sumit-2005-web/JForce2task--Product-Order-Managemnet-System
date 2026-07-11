package com.Ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.Entity.Product;
import com.Ecommerce.Service.ProductService;
import com.Ecommerce.Utility.SessionUtil;
import com.Ecommerce.dto.ProductDTO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;

    @GetMapping
    public String listProducts(Model model, HttpSession  session) {
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        model.addAttribute("products",
                productService.getAllProducts());

        return "admin/dashboard";
    }

    @GetMapping("/new")
    public String newProduct(Model model, HttpSession session) {
    	
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        model.addAttribute("productDTO",
                new ProductDTO());

        return "admin/add-product";
    }

    @PostMapping
    public String saveProduct(
            @Valid @ModelAttribute ProductDTO dto,
            BindingResult result, HttpSession session ) {
    	
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        if (result.hasErrors()) {
            return "admin/add-product";
        }

        productService.save(dto);

        return "redirect:/admin/products";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable Long id,
                              Model model, HttpSession session) {
    	
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        model.addAttribute("product",
                productService.getById(id));

        return "admin/edit-product";
    }

    @PutMapping("/{id}")
    public String updateProduct(
            @PathVariable Long id,
            @ModelAttribute Product product, HttpSession session) {
    	
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        productService.update(id, product);

        return "redirect:/admin/products";
    }

    @PatchMapping("/{id}/enable")
    public String enable(@PathVariable Long id , HttpSession session) {
    	
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        productService.enable(id);

        return "redirect:/admin/products";
    }

    @PatchMapping("/{id}/disable")
    public String disable(@PathVariable Long id, HttpSession session) {
    	
    	if(!SessionUtil.isAdmin(session)){
    	    return "redirect:/login";
    	}

        productService.disable(id);

        return "redirect:/admin/products";
    }
}
