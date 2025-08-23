package com.vingtor.ReknaHald.factories;

import com.vingtor.ReknaHald.dtos.despesaRequestDTO;
import com.vingtor.ReknaHald.enums.tipoDespesaEnum;
import com.vingtor.ReknaHald.utilities.botTexts;

public class despesaDtoFactory {
    public despesaRequestDTO create(Long chatId, String[] sObject) {

        double value;
        tipoDespesaEnum tipo;

        try {
            value = Double.parseDouble(sObject[3]);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        try {
            if(sObject[1].equalsIgnoreCase("COMIDA")) {
                tipo = tipoDespesaEnum.COMIDA;
            }
            else if(sObject[1].equalsIgnoreCase("LAZER")) {
                tipo = tipoDespesaEnum.LAZER;
            }
            else if(sObject[1].equalsIgnoreCase("BELEZA")) {
                tipo = tipoDespesaEnum.BELEZA;
            }
            else if(sObject[1].equalsIgnoreCase("JOGO")) {
                tipo = tipoDespesaEnum.JOGO;
            }
            else if(sObject[1].equalsIgnoreCase("CASA")) {
                tipo = tipoDespesaEnum.CASA;
            }
            else if(sObject[1].equalsIgnoreCase("ROUPA")) {
                tipo = tipoDespesaEnum.ROUPA;
            }
            else {
                throw new RuntimeException("Tipo desconhecido");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new despesaRequestDTO(chatId, tipo, sObject[2], value);
    }
}
