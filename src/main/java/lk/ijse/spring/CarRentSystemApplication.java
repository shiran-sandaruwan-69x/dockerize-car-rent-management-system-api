package lk.ijse.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarRentSystemApplication {

	public String PORT=System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(CarRentSystemApplication.class);
		System.out.println("spring start .....!");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
