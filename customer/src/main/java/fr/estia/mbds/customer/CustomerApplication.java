package fr.estia.mbds.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository)
	{
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder()
							.firstName("Yanis")
							.lastName("Bently")
							.email("Yanis.Bently@uca.fr")
							.build(),
					Customer.builder()
							.firstName("Zakaria")
							.lastName("Hugo")
							.email("Zakaria.Hugo@uca.fr")
							.build(),
					Customer.builder()
							.firstName("Valeri")
							.lastName("Lapshina")
							.email("valeriia.lapshina@uca.fr")
							.build(),
					Customer.builder()
							.firstName("Badr")
							.lastName("Travis")
							.email("Badr.Travis@uca.fr")
							.build()
			);
			customerRepository.saveAll(customers);
		};
	}
}
