package com.vingtor.ReknaHald.processor;

import com.vingtor.ReknaHald.factories.ProcessorFactory;
import com.vingtor.ReknaHald.utilities.botTexts;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class telegramRequestProcessor {

    private final ProcessorFactory processorFactory;
    private Processor processor;

    public telegramRequestProcessor(ProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public String processRequest(Long chatId, String[] request) {

        String processorType = request[0].substring(1);
        processor = processorFactory.getProcessor(processorType);

        if (request[0].equalsIgnoreCase(botTexts.helloKey)) {
            return botTexts.startText;
        }

        else if(request[0].equalsIgnoreCase(botTexts.helpKey)) {
            return botTexts.helpText;
        }

        else if(request[0].equalsIgnoreCase(botTexts.addDespesaKey)) {

            if(request.length == 4) {
                try {
                    processor.process(chatId, request); //todo: passar o chatId
                    return botTexts.despesaInsertSuccess;

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                throw new RuntimeException(botTexts.syntaxError);
            }
        }

        else if(request[0].equalsIgnoreCase(botTexts.addUserKey)) {

            if(request.length == 2) {
                try {
                    processor.process(chatId, request);
                    return botTexts.userInsertSuccess;
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
