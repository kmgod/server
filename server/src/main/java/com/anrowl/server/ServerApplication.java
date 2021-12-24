package com.anrowl.server;

import com.anrowl.server.model.Server;
import com.anrowl.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static com.anrowl.server.enumeration.Status.SERVER_DOWN;
import static com.anrowl.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return agrs -> {
			serverRepo.save(new Server(null, "192.168.0.101", "Windows 2018","32GB","File Server","http://localhost:8080/server/image/server1.jpg", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.123.102", "Centos Linux","32GB","File Server","http://localhost:8080/server/image/server2.jpg", SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.123.103", "IBM P595","32GB","File Server","http://localhost:8080/server/image/server3.jpg", SERVER_UP));
			serverRepo.save(new Server(null, "192.168.123.104", "HP Tower Series","32GB","File Server","http://localhost:8080/server/image/server4.jpg", SERVER_DOWN));

		};
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-type",
				"Accept","Jwt-Token","Authorization","Origin, Accept","x-Requested-With",
				"Access-Control-Request-Method","Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Jwt-Token","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);

	}


}
