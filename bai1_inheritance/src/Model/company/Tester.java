package Model.company;

import Model.Person;

import java.util.Scanner;

public class Tester extends Person {
    private String testTools;

    public Tester() {
    }

    public String getTestTools() {
        return testTools;
    }

    public void setTestTools(String testTools) {
        this.testTools = testTools;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("testTools: ");
        String testTools = sc.nextLine();
        this.testTools = testTools;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("-" + this.getTestTools());
    }
}
