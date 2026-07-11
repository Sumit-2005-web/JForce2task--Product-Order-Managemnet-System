package com.Ecommerce.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleNotFound(ResourceNotFoundException ex,
                                 Model model){

        model.addAttribute("error", ex.getMessage());

        return "error";
    }

    @ExceptionHandler(InsufficientStockException.class)
    public String handleStock(InsufficientStockException ex,
                              Model model){

        model.addAttribute("error", ex.getMessage());

        return "error";
    }

}