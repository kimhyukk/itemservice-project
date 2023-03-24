package hello.itemservice.project;

import hello.itemservice.project.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//@Import(Config.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.project")
public class ItemserviceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemserviceProjectApplication.class, args);
	}

}
