package com.alina.web.productproject.controllers;

import com.alina.web.productproject.Forms.SignUpForm;
import com.alina.web.productproject.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getSignPage(){
        return "signUp";
    }

    @PostMapping
    public String signUpUser(SignUpForm form){
        signUpService.signUpUser(form);
        return "redirect:/signIn";
    }
}
