package com.example.pizzaCafe;

import com.example.pizzaCafe.controller.ImageController;
import com.example.pizzaCafe.entity.Image;
import com.example.pizzaCafe.entity.Pizza;
import com.example.pizzaCafe.entity.UserRole;
import com.example.pizzaCafe.service.ImageService;
import com.example.pizzaCafe.service.PizzaService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class PizzaCafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaCafeApplication.class, args);
	}
	@Autowired
	private ImageService imageService;
	@Autowired
	private PizzaService pizzaService;
	@Bean
	public CommandLineRunner bootstrap() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				String pizza1 = new String("Четыре сезона");
				String pizza2 = new String("Гавайская");
				String pizza3 = new String("Мексиканская");
				String pizza4 = new String("Пепперони");

				Long price1 = 420L;
				Long price2 = 500L;
				Long price3 = 560L;
				Long price4 = 380L;

				String composition = "Ветчина из цыпленка, сыры чеддер и пармезан, моцарелла, красный лук, чеснок, соус альфредо, итальянские травы, томаты";

				Image image1 = imageService.saveImage(new File("./src/main/resources/static/images/4sezona.jpg"));
				Image image2 = imageService.saveImage(new File("./src/main/resources/static/images/gavayskaya.jpg"));
				Image image3 = imageService.saveImage(new File("./src/main/resources/static/images/meksikanskaya-picca.jpg"));
				Image image4 = imageService.saveImage(new File("./src/main/resources/static/images/XXL.jpg"));

				pizzaService.createPizza(Pizza.builder().pizzaName(pizza1).price(price1).composition(composition).image(image1).build());
				pizzaService.createPizza(Pizza.builder().pizzaName(pizza2).price(price2).composition(composition).image(image2).build());
				pizzaService.createPizza(Pizza.builder().pizzaName(pizza3).price(price3).composition(composition).image(image3).build());
				pizzaService.createPizza(Pizza.builder().pizzaName(pizza4).price(price4).composition(composition).image(image4).build());

				UserRole user = new UserRole("ROLE_USER");
				UserRole admin = new UserRole("ROLE_ADMIN");
			}
		};
	}
}
