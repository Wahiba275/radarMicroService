package org.sid.radarmicroservice;

import org.sid.radarmicroservice.entities.Radar;
import org.sid.radarmicroservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;


@SpringBootApplication
public class RadarMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadarMicroServiceApplication.class, args);
	}
    Random random = new Random();
	List<Double> vM = List.of(120.0 , 140.12 , 160.0 );
	@Bean
	CommandLineRunner start(RadarRepository radarRepository){
		return args -> {
			for (int i = 0; i < 5; i++) {
				Double vitesse_max =  vM.get(random.nextInt(vM.size()));
				Radar radar = Radar.builder()
						.idR("RADAR00"+i)
						.latitude( 33.57)
						.longitude(-7.58)
						.build();
				radar.setVitesse_max_R(vitesse_max);
				radarRepository.save(radar);
				//System.out.println(radarRepository.findAll());
			}
		};
	   }
}
