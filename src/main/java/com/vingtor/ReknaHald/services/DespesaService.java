package com.vingtor.ReknaHald.services;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import com.vingtor.ReknaHald.entidade.Despesa;
import com.vingtor.ReknaHald.repository.DespesaRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.time.Instant;
import java.util.UUID;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public void createDespesa(despesaRequestDTO createRequestDto) {

        var despesa = new Despesa(
                UUID.randomUUID(),
                createRequestDto.getType(),
                createRequestDto.getLocal(),
                createRequestDto.getValue(),
                createRequestDto.getChatId(),
                Instant.now()
        );

        despesaRepository.save(despesa);
    }
}
