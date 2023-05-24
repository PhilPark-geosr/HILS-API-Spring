package ppark.springppark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

public class testController {


    @GetMapping("helloppark")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }


}

