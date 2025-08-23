package com.vingtor.ReknaHald.factories;

import com.vingtor.ReknaHald.processor.Processor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProcessorFactory {

    private final Map<String, Processor> processors;

    public ProcessorFactory(List<Processor> processorList) {
        this.processors = processorList.stream()
                .collect(Collectors.toMap(
                        p -> p.getClass().getSimpleName().toLowerCase().substring(0, p.getClass().getSimpleName().toLowerCase().length() - 9),
                        p -> p
                ));
    }

    public Processor getProcessor(String tipo) {
        Processor processor = processors.get(tipo.toLowerCase());
        if (processor == null) throw new RuntimeException("Processor não encontrado");
        return processor;
    }
}

