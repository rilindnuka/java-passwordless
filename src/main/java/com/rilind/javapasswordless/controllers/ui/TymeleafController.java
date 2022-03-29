package com.rilind.javapasswordless.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TymeleafController {


    @GetMapping("/")
    public String goToIndex(){
        return "index";
    }
}
