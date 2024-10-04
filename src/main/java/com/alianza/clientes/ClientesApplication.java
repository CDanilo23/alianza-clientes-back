package com.alianza.clientes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

	public static boolean esMultiploPotenciasDe2(int num) {

		if(num == 1 || num == 2){
			return true;
		}

		int potencia = 1;
		while (potencia < num) {
			potencia *= 2;
		}
		return potencia == num;

		//Math.min(1,2);
	}
}
