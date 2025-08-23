package com.vingtor.ReknaHald.processor;

import com.vingtor.ReknaHald.utilities.botTexts;

public class telegramRequestProcessor {

    private Processor processor;

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
                    processor = new despesaProcessor();
                    processor.process(request);

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
