package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping("/roll-dice")
    public String showRollDicePage(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String guessTheDice(@PathVariable int guess, Model model) {
        int diceRoll = (int) (Math.random() * 6) + 1;
        String result;
        if (diceRoll == guess){
            result = "You Win!";
        } else {
            result = "You Lose!";
        }
        model.addAttribute("result", result);
        model.addAttribute("answer", diceRoll);
        model.addAttribute("guess", guess);
        return "roll-dice-guess";
    }

//    @GetMapping("/roll-dice/n")
//    @ResponseBody
//    public String randomDice(Model model){
//        int diceRoll = (int) (Math.random() * 6) + 1;
//        model.getAttribute("diceRoll", diceRoll);
//        return "roll-dice";
//    }


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
