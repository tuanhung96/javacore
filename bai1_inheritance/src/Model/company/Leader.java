package Model.company;

import Model.Person;

import java.util.Scanner;

public class Leader extends Person {
    private static final int LUONG_CO_BAN = 10000000;
    private int teamSize;

    public Leader() {
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("teamSize: ");
        int teamSize = sc.nextInt();
        this.teamSize = teamSize;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("-" + this.getTeamSize());
        this.bonus();
    }

    public void bonus() {
        System.out.print("Bonus: ");
        if(this.teamSize > 10) System.out.println(LUONG_CO_BAN*0.5);
        else System.out.println(LUONG_CO_BAN*0.1);
    }
}
