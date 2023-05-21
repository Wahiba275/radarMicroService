package org.sid.radarmicroservice;

import org.sid.radarmicroservice.entities.Radar;
import org.sid.radarmicroservice.feign.ImmatriculationRestController;
import org.sid.radarmicroservice.feign.InfractionRestController;
import org.sid.radarmicroservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class RadarMicroServiceApplication {

	public RadarMicroServiceApplication(RadarRepository radarRepository, ImmatriculationRestController immatriculationRestController, InfractionRestController infractionRestController) {
		this.radarRepository = radarRepository;
		this.immatriculationRestController = immatriculationRestController;
		this.infractionRestController = infractionRestController;
	}

	public static void main(String[] args) {
		SpringApplication.run(RadarMicroServiceApplication.class, args);
	}
    Random random = new Random();
	private final RadarRepository radarRepository;
	private final ImmatriculationRestController immatriculationRestController ;
	private final InfractionRestController infractionRestController ;
	List<Double> vM = List.of(120.0 , 140.12 , 160.0 );
	@Bean
	CommandLineRunner start(RadarRepository radarRepository){
		return args -> {
			for (int i = 0; i < 5; i++) {
				Radar radar = Radar.builder()
						.idR("RADAR00"+i)
						.latitude( 33.57)
						.longitude(-7.58)
						.vitesse_max_R(vM.get(random.nextInt(vM.size())))
						.build();
				radarRepository.save(radar);
				//System.out.println(radarRepository.findAll());
			}
		};
	   }
}
