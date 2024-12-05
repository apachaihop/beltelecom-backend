package net.btc.microservices;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@SpringBootApplication
@RestController
public class MicroServicesApplication {

    public static final int PORT = 8080;

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("microservices");

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MicroServicesApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", PORT));
        app.run(args);
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
