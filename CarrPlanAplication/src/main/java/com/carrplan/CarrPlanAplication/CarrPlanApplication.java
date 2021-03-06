package com.carrplan.CarrPlanAplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class CarrPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrPlanApplication.class, args);
	}

	@GetMapping("/")
	public String olaMundo(){
		return "Olá mundo";
	}
}
