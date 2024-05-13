package com.ra.btap2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @RequestMapping("/cal")
    public String cal(@RequestParam("firstNumber") Double firstNumber, @RequestParam("secondNumber") Double secondNumber,@RequestParam("cal") String cal, Model model){
        double result = 0D;
        switch (cal){
            case "+":
                result  = firstNumber+secondNumber;
                break;
            case "-":
                result = firstNumber-secondNumber;
                break;
            case "*" :
                result = firstNumber*secondNumber;
                break;
            case "/":
                result = firstNumber/secondNumber;
                break;
            default:
                break;
        }
        model.addAttribute("result",result);
        return "home";
    }
}
