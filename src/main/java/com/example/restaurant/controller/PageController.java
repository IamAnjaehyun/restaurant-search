package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/main") //그냥 localhost:8080 해도 index 페이지로 가고 localhost:8080/pages/main 해도 index로 감
    public ModelAndView main(){
        return new ModelAndView("index");
    }
}
