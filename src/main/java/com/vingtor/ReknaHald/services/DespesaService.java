package com.vingtor.ReknaHald.services;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import com.vingtor.ReknaHald.entidade.Despesa;
import com.vingtor.ReknaHald.entidade.Usuario;
import com.vingtor.ReknaHald.repository.DespesaRepository;
import com.vingtor.ReknaHald.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.time.Instant;
import java.util.List;

@Service
@Configurable
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void createDespesa(despesaRequestDTO createRequestDto) {

        Usuario usuario = usuarioRepository.findById(createRequestDto.getChatId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var despesa = new Despesa(
                null,
                createRequestDto.getType(),
                createRequestDto.getLocal(),
                createRequestDto.getValue(),
                usuario,
                Instant.now()
        );

        despesaRepository.save(despesa);
    }
}
