package asw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import asw.dbManagement.model.Participant;
import asw.dbManagement.repository.ParticipantRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public CommandLineRunner initDB(ParticipantRepository repository) throws ParseException {

		return (args) -> {
			// Inserción en la base de datos
			repository.save(new Participant("Paco", "123456", "paco@hotmail.com", "12345678A","Persona",1));

			// Inserción en la base de datos
			repository.save(new Participant("Pepe", "123456", "pepe@gmail.com", "87654321B","Persona",1));

			// Inserción en la base de datos
			repository.save(new Participant("Carmen", "123456", "carmen@yahoo.com", "11223344C","Persona",1));

			// Inserción en la base de datos
			repository.save(new Participant("Isabel", "123456", "isabel@gmail.com", "22334455D","Persona",1));

			// Inserción en la base de datos
			repository.save(new Participant("María", "123456", "maria@gmail.com", "33445566E","Persona",1));

			// Inserción en la base de datos
			repository.save(new Participant("Jose", "123456", "jose@gmail.com", "44556677F","Persona",1));

		};
	}
}