package colombo.OpenBootCamp_SpringBoot.service;

import colombo.OpenBootCamp_SpringBoot.entities.Laptop;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Laptop laptop = new Laptop(1L, "Lenovo", "Thinkpad", 4, 36.5, LocalDate.now(), true);
        LaptopPriceCalculator calculadora = new LaptopPriceCalculator();

        double price = calculadora.calculatePrice(laptop);
        System.out.println("Price: " + price);
        //Comprobamos aserciones
        assertTrue(price >0);

    }
}