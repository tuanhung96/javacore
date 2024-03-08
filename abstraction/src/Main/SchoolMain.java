package Main;

import Model.School.Student;
import Service.School.StudentServiceImpl;

import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Student: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] arr = new Student[n];
        StudentServiceImpl studentService = new StudentServiceImpl();
        for(int i=0; i<n; i++) {
            Student student = new Student();
            studentService.input(student);
            arr[i] = student;
        }

        for(int i=0; i<n; i++) {
            studentService.info(arr[i]);
        }

        int maxAgeIndex = 0;
        int maxAge = 0;
        for(int i=0; i<n; i++) {
            if(arr[i].getAge() > maxAge) {
                maxAge = arr[i].getAge();
                maxAgeIndex = i;
            }
        }
        studentService.info(arr[maxAgeIndex]);
    }
}
