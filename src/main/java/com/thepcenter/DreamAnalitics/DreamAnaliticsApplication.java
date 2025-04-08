package com.thepcenter.DreamAnalitics;

import com.thepcenter.DreamAnalitics.controller.Control;
import com.thepcenter.DreamAnalitics.view.ConsoleView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DreamAnaliticsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DreamAnaliticsApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		ConsoleView vista = new ConsoleView();
		Control controlador = new Control(vista);
		controlador.iniciar();
	}
}
