package Model.company;

import Model.Person;

import java.util.Scanner;

public class Developer extends Person {
    private String programLanguage;

    public Developer() {
    }

    public String getProgramLanguage() {
        return programLanguage;
    }

    public void setProgramLanguage(String programLanguage) {
        this.programLanguage = programLanguage;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("programLanguage: ");
        String programLanguage = sc.nextLine();
        this.programLanguage = programLanguage;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("-" + this.getProgramLanguage());
    }
}
