package com.vingtor.ReknaHald.services;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import com.vingtor.ReknaHald.entidade.Despesa;
import com.vingtor.ReknaHald.repository.DespesaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.time.Instant;
import java.util.UUID;

@Service
@Configurable
public class DespesaService {

    private DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public void createDespesa(despesaRequestDTO createRequestDto) {

        var despesa = new Despesa(
                null,
                createRequestDto.getType(),
                createRequestDto.getLocal(),
                createRequestDto.getValue(),
                createRequestDto.getChatId(),
                Instant.now()
        );

        despesaRepository.save(despesa);
    }
}
