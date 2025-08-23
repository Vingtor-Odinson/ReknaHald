package com.vingtor.ReknaHald.processor;

import com.vingtor.ReknaHald.dtos.CreateUsuarioDto;
import com.vingtor.ReknaHald.factories.UsuarioDtoFactory;
import com.vingtor.ReknaHald.services.UsuarioService;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProcessor implements Processor {

    private final UsuarioService usuarioService;

    public UsuarioProcessor(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void process(Long chatId, String[] request) {
        UsuarioDtoFactory usuarioDtoFactory = new UsuarioDtoFactory();
        CreateUsuarioDto dto = usuarioDtoFactory.create(chatId, request);

        usuarioService.createUsuario(dto);
    }
}
