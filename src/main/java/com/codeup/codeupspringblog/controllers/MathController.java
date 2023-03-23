package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{number}/and/{secondNumber}")
    @ResponseBody
    public int add(@PathVariable int number, @PathVariable int secondNumber) {
        return number + secondNumber;
    }

    @GetMapping("/subtract/{number}/from/{secondNumber}")
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int secondNumber) {
        return  secondNumber - number ;
    }

    @GetMapping("/multiply/{number}/and/{secondNumber}")
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int secondNumber) {
        return number * secondNumber;
    }

    @GetMapping("/divide/{number}/by/{secondNumber}")
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int secondNumber) {
        return number/secondNumber;
    }
}
