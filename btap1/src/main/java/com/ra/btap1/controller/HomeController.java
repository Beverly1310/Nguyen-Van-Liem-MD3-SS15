package com.ra.btap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
      @RequestMapping("/")
    public String home(){
          return "home";
      }
    @RequestMapping("/sandwich")
    public String sandwich(@RequestParam("condiment") String[] condiment, Model model){
          model.addAttribute("condiment",condiment);
          return "result";
    }
}
