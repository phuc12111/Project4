package com.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class Index {
    
    
    
    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String showcart() {
        return "cart";
    }
}
