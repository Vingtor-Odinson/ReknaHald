package com.vingtor.ReknaHald;

import com.vingtor.ReknaHald.bots.ReknBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class ReknaHaldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReknaHaldApplication.class, args);
	}

	@Bean
	public TelegramBotsApi telegramBotsApi(ReknBot reknBot) throws TelegramApiException {
		TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
		api.registerBot(reknBot); // registra a instância gerenciada pelo Spring
		return api;
	}

}