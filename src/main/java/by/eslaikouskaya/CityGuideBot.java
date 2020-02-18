package by.eslaikouskaya;

import by.eslaikouskaya.pojo.AdditionalInfo;
import by.eslaikouskaya.pojo.City;
import by.eslaikouskaya.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class CityGuideBot extends TelegramLongPollingBot {

	@Autowired
	CityService service;

	SendMessage message = new SendMessage();

	@Override
	public void onUpdateReceived(Update update) {
		System.out.println(update.getMessage().getText());
		try {
			City city = service.findCityByCityName(update.getMessage().getText());
			List<AdditionalInfo> infos = service.findInfoByCityId(city.getId());
			message.setText(infos.get((int) (Math.random()*infos.size())).getInfo());
		} catch (NullPointerException e){
			message.setText("Try another city please");
		}
		message.setChatId(update.getMessage().getChatId());
		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return Util.username;
	}

	@Override
	public String getBotToken() {
		return Util.token;
	}
}
