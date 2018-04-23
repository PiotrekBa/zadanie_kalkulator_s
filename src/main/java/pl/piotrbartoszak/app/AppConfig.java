package pl.piotrbartoszak.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "pl.piotrbartoszak")
public class AppConfig extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
