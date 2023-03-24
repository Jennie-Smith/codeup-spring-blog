package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {

    @GetMapping("/")
    public String landing() {
        return "This is the landing page!";
    }
//    @GetMapping("/home/{personName}")
//    public String welcome(@RequestParam(name = "age") int age, @PathVariable String personName, Model model) {
//        model.addAttribute("name", "Jennie Smith");
//        model.addAttribute("personAge", age);
//        model.addAttribute("personName", personName);
//        return "home/home.html";
//    }
//
//    @GetMapping("/join")
//    public String showJoinForm(){
//        return "join";
//    }
//    @PostMapping("/join")
//    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
//        model.addAttribute("cohort", "Welcome to " + cohort + "!");
//        return "join";
//    }

}
