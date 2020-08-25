package com.Tacos.Tacos.controllers;

import com.Tacos.Tacos.Order;
//import com.sun.java.util.jar.pack.Utils;
import com.Tacos.Tacos.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors,
                               SessionStatus sessionStatus){
        //log.info("Order submitted: "+order);
        if(errors.hasErrors()){
            return "orderForm";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
