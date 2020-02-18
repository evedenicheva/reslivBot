package by.eslaikouskaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyBootApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(MyBootApplication.class, args);
	}

}
