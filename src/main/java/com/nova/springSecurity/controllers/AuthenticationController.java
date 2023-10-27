package com.nova.springSecurity.controllers;

import com.nova.springSecurity.models.ApplicationUser;
import com.nova.springSecurity.models.LoginResponseDto;
import com.nova.springSecurity.models.RegistrationDto;
import com.nova.springSecurity.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDto body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody RegistrationDto body){
        return authenticationService.loginUser(body.getUsername(),body.getPassword());
    }
}
