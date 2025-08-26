package com.vingtor.ReknaHald.processor;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import com.vingtor.ReknaHald.factories.despesaDtoFactory;
import com.vingtor.ReknaHald.services.DespesaService;
import org.springframework.stereotype.Component;

@Component
public class despesaProcessor implements Processor {

    private final DespesaService despesaService;

    public despesaProcessor(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    public void process(Long chatId, String[] request) {
        despesaDtoFactory factory = new despesaDtoFactory();
        despesaRequestDTO dto = factory.create(chatId, request);

        despesaService.createDespesa(dto);
    }

}
