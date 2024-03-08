package Main;

import Model.Student;

import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Student: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] arr = new Student[n];
        for(int i=0; i<n; i++) {
            Student student = new Student();
            student.input();
            arr[i] = student;
        }

        for(int i=0; i<n; i++) {
            arr[i].info();
        }
    }
}
