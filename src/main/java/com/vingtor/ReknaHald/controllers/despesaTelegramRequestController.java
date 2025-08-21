package com.vingtor.ReknaHald.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telegram/despesa")
public class despesaTelegramRequestController {

    @GetMapping
    public String HelloWorld() {
        return "Hello world";
    }
}
