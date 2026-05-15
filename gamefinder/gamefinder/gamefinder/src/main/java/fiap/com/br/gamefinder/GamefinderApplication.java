package fiap.com.br.gamefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GamefinderApplication {

    public static void main(String[] args) {
        // Garantindo que a aplicação use o contexto correto
        SpringApplication.run(GamefinderApplication.class, args);
    }

}