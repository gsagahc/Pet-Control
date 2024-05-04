package petcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class PetControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetControlApplication.class, args);
	}

}
