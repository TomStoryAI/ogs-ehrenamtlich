package de.children.agplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value="classpath:hsqldb_properties.xml") // Start hsql server to access from application
public class AgPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgPlannerApplication.class, args);
    }

}
