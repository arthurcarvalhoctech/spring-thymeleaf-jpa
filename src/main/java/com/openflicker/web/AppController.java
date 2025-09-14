package com.openflicker.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {


    @GetMapping("/login")
    public String login() {
        // Return the name of the Thymeleaf template for the login page
        System.out.println("login");
        return "login";
    }

    @GetMapping("/test")
    public String test() {
        // Return the name of the Thymeleaf template for the login page
        System.out.println("test");
        return "test";
    }

    @GetMapping("/price")
    public String price() {
        // Return the name of the Thymeleaf template for the login page
        System.out.println("price");
        return "price";
    }



//    @GetMapping({"/", "/home"})
//    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
//        // @AuthenticationPrincipal injects the currently logged-in user's details.
//        // We add the username to the model so we can display it in the view.
//        model.addAttribute("username", userDetails.getUsername());
//        // Return the name of the Thymeleaf template for the home page
//        return "home";
//    }


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/dash")
    public String dash() {
        return "dash";
    }
}
