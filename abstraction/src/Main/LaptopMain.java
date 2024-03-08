package Main;

import Model.Laptop;
import Service.LaptopServiceImpl;

public class LaptopMain {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        LaptopServiceImpl laptopService = new LaptopServiceImpl();
        laptopService.input(laptop);
        laptopService.info(laptop);
    }
}
