package Main;

import Model.Chicken;
import Model.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Hello world!");
            System.out.println("1. Dog");
            System.out.println("2. Chicken");
            System.out.print("Vui long chon: ");
            String choice = sc.next();
            if(choice.equals("0")) break;
            switch (choice) {
                case "1":
                    System.out.print("Nhap so luong Dog: ");
                    int numberOfDog = sc.nextInt();
                    sc.nextLine();
                    Dog[] dogs = new Dog[numberOfDog];
                    for(int i=0; i<numberOfDog; i++) {
                        Dog newDog = new Dog();
                        newDog.input();
                        dogs[i] = newDog;
                    }

                    for(int i=0; i<numberOfDog; i++) {
                        dogs[i].info();
                    }
                    break;
                case "2":
                    System.out.print("Nhap so luong Chicken: ");
                    int numberOfChicken = sc.nextInt();
                    sc.nextLine();
                    Chicken[] chickens = new Chicken[numberOfChicken];
                    for(int i=0; i<numberOfChicken; i++) {
                        Chicken newChicken = new Chicken();
                        newChicken.input();
                        chickens[i] = newChicken;
                    }

                    for(int i=0; i<numberOfChicken; i++) {
                        chickens[i].info();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}