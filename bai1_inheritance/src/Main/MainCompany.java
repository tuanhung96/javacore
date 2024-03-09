package Main;

import Model.company.Developer;
import Model.company.Leader;
import Model.company.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCompany {
    private static Leader[] leaderArr;
    private static Developer[] developerArr;
    private static Tester[] testerArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Nhap thong tin cua:");
            System.out.println("1. Leader");
            System.out.println("2. Developer");
            System.out.println("3. Tester");
            System.out.println("0. Exit");
            System.out.print("Vui long chon: ");
            String choice = sc.next();
            if(choice.equals("0")) break;

            switch (choice) {
                case "1":
                    System.out.print("Nhap so luong Leader: ");
                    int numberOfLeader = sc.nextInt();
                    sc.nextLine();
                    leaderArr = new Leader[numberOfLeader];
                    for(int i=0; i<numberOfLeader; i++) {
                        Leader leader = new Leader();
                        leader.input();
                        leaderArr[i] = leader;
                    }

                    for(int i=0; i<numberOfLeader; i++) {
                        leaderArr[i].info();
                    }

                    System.out.print("Danh sach Leader teamsize > 5: ");
                    List<Leader> leaderList = new ArrayList<>();
                    for(int i=0; i<numberOfLeader; i++) {
                        if(leaderArr[i].getTeamSize() > 10) leaderList.add(leaderArr[i]);
                    }

                    for (Leader leader: leaderList) {
                        leader.info();
                    }
                    break;
                case "2":
                    System.out.print("Nhap so luong Developer: ");
                    int numberOfDeveloper = sc.nextInt();
                    sc.nextLine();
                    developerArr = new Developer[numberOfDeveloper];
                    for(int i=0; i<numberOfDeveloper; i++) {
                        Developer developer = new Developer();
                        developer.input();
                        developerArr[i] = developer;
                    }

                    for(int i=0; i<numberOfDeveloper; i++) {
                        developerArr[i].info();
                    }

                    System.out.print("Danh sach Java Developer: ");
                    List<Developer> developerList = new ArrayList<>();
                    for(int i=0; i<numberOfDeveloper; i++) {
                        if(developerArr[i].getProgramLanguage().equals("Java")) developerList.add(developerArr[i]);
                    }

                    for (Developer developer: developerList) {
                        developer.info();
                    }

                    break;
                case "3":
                    System.out.print("Nhap so luong Tester: ");
                    int numberOfTester = sc.nextInt();
                    sc.nextLine();
                    testerArr = new Tester[numberOfTester];
                    for(int i=0; i<numberOfTester; i++) {
                        Tester tester = new Tester();
                        tester.input();
                        testerArr[i] = tester;
                    }

                    for(int i=0; i<numberOfTester; i++) {
                        testerArr[i].info();
                    }
                    break;
                default:
                    System.out.print("Vui long nhap dung dinh dang");
                    break;
            }
        }

    }
}
