package com.vingtor.ReknaHald.validator;

import com.vingtor.ReknaHald.utilities.botTexts;

public class telegramRequestProcessor {

    public String processRequest(String[] request) {

        if (request[0].equalsIgnoreCase(botTexts.helloKey)) {
            return botTexts.startText;
        }

        else if(request[0].equalsIgnoreCase(botTexts.helpKey)) {
            return botTexts.helpText;
        }

        else if(request[0].equalsIgnoreCase(botTexts.addDespesaKey)) {
            if(request.length == 4) {
                try {
                    //cadastra despesa
                    return botTexts.despesaInsertSuccess;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                throw new RuntimeException(botTexts.syntaxError);
            }
        }

        else {
            throw new RuntimeException(botTexts.didntUnderstand);
        }
    }

}
