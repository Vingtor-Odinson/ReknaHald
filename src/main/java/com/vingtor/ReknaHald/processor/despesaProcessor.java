package com.vingtor.ReknaHald.processor;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import com.vingtor.ReknaHald.factories.despesaDtoFactory;
import com.vingtor.ReknaHald.services.DespesaService;

public class despesaProcessor implements Processor {

    private despesaRequestDTO dto;
    private DespesaService despesaService;

    public void process(String[] request) {
        despesaDtoFactory factory = new despesaDtoFactory();
        dto = factory.create(0L, request);

        despesaService = new DespesaService();
        despesaService.createDespesa(dto);

    }

}
