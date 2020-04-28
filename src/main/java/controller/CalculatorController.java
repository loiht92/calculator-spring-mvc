package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculate")
    public String calculate(@RequestParam(required = false, defaultValue = "0") int firstOperand,
                            @RequestParam(required = false, defaultValue = "0") int secondOperand,
                            @RequestParam(required = false, defaultValue = "+") String operator,
                            ModelMap model) {
        int result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                operator = "Addition";
                break;

            case "-":
                result = firstOperand - secondOperand;
                operator = "Subtraction";
                break;

            case "*":
                result = firstOperand * secondOperand;
                operator = "Multiplication";
                break;

            case "/":
                result = firstOperand / secondOperand;
                operator = "Division";
                break;

        }
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);

        return "index";
    }
}