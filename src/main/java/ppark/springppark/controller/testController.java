package ppark.springppark.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class testController {
    @GetMapping("helloppark")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
