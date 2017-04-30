package io.github.aparnachaudhary;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"config/core-application.properties", "config/application.properties"})
public class SpringJerseyRestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.CONSOLE)
                .sources(CoreApplication.class, SpringJerseyRestApplication.class)
                .run(args);
    }
}
