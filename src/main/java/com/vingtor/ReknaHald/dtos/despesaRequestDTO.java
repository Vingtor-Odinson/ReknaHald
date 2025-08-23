package com.vingtor.ReknaHald.dtos;

import com.vingtor.ReknaHald.enums.tipoDespesaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class despesaRequestDTO {
    private Long chatId;
    private tipoDespesaEnum type;
    private String local;
    private double value;
}
