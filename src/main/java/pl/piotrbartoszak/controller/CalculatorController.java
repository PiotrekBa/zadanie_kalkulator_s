package pl.piotrbartoszak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/get-currency")
    @ResponseBody
    public String getValue() {
        return "Hello";
    }
}
