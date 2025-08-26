package com.vingtor.ReknaHald.services;

import com.vingtor.ReknaHald.dtos.CreateUsuarioDto;
import com.vingtor.ReknaHald.entidade.Usuario;
import com.vingtor.ReknaHald.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Configurable
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void createUsuario(CreateUsuarioDto dto) {
        var usuario = new Usuario(
                dto.getChatId(),
                dto.getName(),
                new ArrayList<>()
        );

        usuarioRepository.save(usuario);
    }
}
