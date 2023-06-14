package colombo.OpenBootCamp_SpringBoot.service;

import colombo.OpenBootCamp_SpringBoot.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){
        double price = laptop.getPrice();
        if (laptop.iswindows()){
            price = price + 5;
        }
        price += 3.99;
        return price;
    }

}
