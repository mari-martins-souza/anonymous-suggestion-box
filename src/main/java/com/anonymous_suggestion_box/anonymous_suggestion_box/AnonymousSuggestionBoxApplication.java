package com.anonymous_suggestion_box.anonymous_suggestion_box;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Caixa de Sugestões", version = "1.0", description = "Mayumi Corp"))
public class AnonymousSuggestionBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousSuggestionBoxApplication.class, args);
	}

}
