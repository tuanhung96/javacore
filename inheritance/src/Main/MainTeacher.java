package Main;

import Model.Person;
import Model.Teacher;

import java.util.Scanner;

public class MainTeacher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Teacher: ");
        int n = sc.nextInt();
        sc.nextLine();
        Teacher[] arr = new Teacher[n];
        for(int i=0; i<n; i++) {
            Teacher teacher = new Teacher();
            teacher.input();
            arr[i] = teacher;
        }

        for(int i=0; i<n; i++) {
            arr[i].info();
        }
    }
}