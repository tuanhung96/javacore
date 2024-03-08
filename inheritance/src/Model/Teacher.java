package Model;

import java.util.Scanner;

public class Teacher extends Person{
    private String subject;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Subject: ");
        String subject = sc.nextLine();
        this.subject = subject;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("-" + this.getSubject());
    }
}
