package com.vingtor.ReknaHald.services;

import com.vingtor.ReknaHald.dtos.CreateUsuarioDto;
import com.vingtor.ReknaHald.entidade.Usuario;
import com.vingtor.ReknaHald.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void createUsuario(CreateUsuarioDto dto) {
        var usuario = new Usuario(
                null,
                dto.getChatId(),
                dto.getName()
        );

        usuarioRepository.save(usuario);
    }
}
