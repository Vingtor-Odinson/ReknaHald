package com.vingtor.ReknaHald.controllers;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/telegram/despesa")
public class despesaTelegramRequestController {

    @GetMapping
    public String HelloWorld() {
        return "Hello world";
    }

    @PostMapping("/{id}")
    public void createDespesa(@PathVariable String id, @RequestBody despesaRequestDTO despesa) {

    }
}
