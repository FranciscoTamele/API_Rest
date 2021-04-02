package curso_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages="model")
@ComponentScan(basePackages="curso.*")
@EnableJpaRepositories(basePackages="curso.repository")
@EnableTransactionManagement
@EnableWebMvc
@RestController
////

public class PrimeiraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiraApiApplication.class, args);
	}

}
