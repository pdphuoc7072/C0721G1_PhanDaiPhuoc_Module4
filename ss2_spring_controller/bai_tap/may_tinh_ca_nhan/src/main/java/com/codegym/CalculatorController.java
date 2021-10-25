package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping (value = "/calculator")
public class CalculatorController {

    @GetMapping
    public String calculator () {
        return "/calculator";
    }

    @PostMapping
    public String calculate (@RequestParam (name = "firstNumber") double firstNumber,
                             @RequestParam (name = "secondNumber") double secondNumber,
                             @RequestParam (name = "calculate") String calculate,
                             Model model) {
        double result = 0;
        switch (calculate) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
        model.addAttribute("result", result);
        return "/calculator";
    }
}
