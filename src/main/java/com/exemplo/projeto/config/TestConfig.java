package com.exemplo.projeto.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exemplo.projeto.entities.Client;
import com.exemplo.projeto.entities.ServiceType;
import com.exemplo.projeto.repositories.ClientRepository;
import com.exemplo.projeto.repositories.ServiceTypeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyyy HH:mm");
		
		Client c1 = new Client(null, "Maria Brown", "98527488");
		Client c2 = new Client(null, "Bob Green", "99856325");
		
		ServiceType st1 = new ServiceType(null, "Faxina na casa", 80.00, sdf.parse("30/10/2020 08:00"), c1);
		ServiceType st2 = new ServiceType(null, "Pintar a casa", 350.00, sdf.parse("30/10/2020 10:30"), c2);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		serviceTypeRepository.saveAll(Arrays.asList(st1, st2));
	}
}