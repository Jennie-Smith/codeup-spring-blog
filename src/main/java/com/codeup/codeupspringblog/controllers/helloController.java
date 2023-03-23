package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
//    url could be anything, use in localhost like this http://localhost:8080/hello
    @GetMapping("/hello")
//    what goes into the body of the html
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}/{last}")
    @ResponseBody
    public String sayhello(@PathVariable String name, @PathVariable String last){
        return "Hello " + name + " " + last + "!";
    }

    @GetMapping("/dice")
    @ResponseBody
    public String rollDice(){
        int diceRoll = (int) (Math.random() * 6) + 1;
        return "Roll-Dice Result: " + diceRoll;
    }

}
