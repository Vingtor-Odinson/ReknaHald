package com.vingtor.ReknaHald.factories;

import com.vingtor.ReknaHald.dtos.CreateUsuarioDto;

public class UsuarioDtoFactory {
    public CreateUsuarioDto create(Long chatId, String[] sObject) {
        return new CreateUsuarioDto(chatId, sObject[1]);
    }
}
