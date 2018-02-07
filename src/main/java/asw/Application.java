package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentRepository;

import java.text.ParseException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initDB(AgentRepository repository) throws ParseException {

		return (args) -> {
			// Inserción en la base de datos
			repository.save(new Agent("Paco", "123456", "paco@hotmail.com", "12345678A", "Calle Valdés Salas nº1","Persona",1));

			// Inserción en la base de datos
			repository.save(new Agent("Pepe", "123456", "pepe@gmail.com", "87654321B", "Calle Valdés Salas nº2","Persona",1));

			// Inserción en la base de datos
			repository.save(new Agent("Carmen", "123456", "carmen@yahoo.com", "11223344C", "Calle Valdés Salas nº3","Persona",1));

			// Inserción en la base de datos
			repository.save(new Agent("Isabel", "123456", "isabel@gmail.com", "22334455D", "Calle Valdés Salas nº4","Persona",1));

			// Inserción en la base de datos
			repository.save(new Agent("María", "123456", "maria@gmail.com", "33445566E", "Calle Valdés Salas nº5","Persona",1));

			// Inserción en la base de datos
			repository.save(new Agent("Jose", "123456", "jose@gmail.com", "44556677F", "Calle Valdés Salas nº6","Persona",1));

		};
	}
}