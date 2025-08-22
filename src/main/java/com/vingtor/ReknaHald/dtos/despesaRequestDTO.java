package com.vingtor.ReknaHald.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class despesaRequestDTO {
    private String type;
    private String local;
    private double value;
}
