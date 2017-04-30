package io.github.aparnachaudhary;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication()
public class ErrorhandlingRestServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
				.sources(CoreApplication.class, ErrorhandlingRestServiceApplication.class)
				.run(args);
	}
}
