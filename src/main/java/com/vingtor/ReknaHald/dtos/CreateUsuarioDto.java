package com.vingtor.ReknaHald.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateUsuarioDto {
    private Long chatId;
    private String name;
}
