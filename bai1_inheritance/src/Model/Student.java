package Model;

import java.util.Scanner;

public class Student extends Person{

    private int year;

    public Student() {
    }

    public Student(String name, int age, int year) {
        super(name, age);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Year: ");
        int year = sc.nextInt();
        this.year = year;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("-" + this.getYear());
    }
}
