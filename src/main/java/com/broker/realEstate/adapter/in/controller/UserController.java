package com.broker.realEstate.adapter.in.controller;

import com.broker.realEstate.domain.entity.User;
import com.broker.realEstate.domain.port.in.RegisterUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/broker")
public class UserController {

    public final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody  User user)
    {

        registerUserUseCase.registerUser(user);
        return ResponseEntity.ok("User registered successfully");

    }

}