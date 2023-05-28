package colombo.OpenBootCamp_SpringBoot;

import colombo.OpenBootCamp_SpringBoot.entities.Laptop;
import colombo.OpenBootCamp_SpringBoot.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class OpenBootCampSpringBootApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OpenBootCampSpringBootApplication.class, args);
		LaptopRepository LaptopRepository = context.getBean(LaptopRepository.class);
//		crear una Laptop
		Laptop Laptop = new Laptop(null, "Lenovo", "ThinkPad", 3, 1440.75, LocalDate.of(2017, 9, 1), true);
		Laptop Laptop2 = new Laptop(null, "Lenovo", "ThinkPad 2", 4, 1100.00, LocalDate.of(2019, 10, 15), true);

//		almacenar una Laptop
		LaptopRepository.save(Laptop);
		LaptopRepository.save(Laptop2);

//		recuperar todos los Laptops
		System.out.println("Numeros de Laptops en la BD: " + LaptopRepository.findAll().size());
		

	}

}
