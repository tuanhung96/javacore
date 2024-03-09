package Service.School;

import Model.School.Student;

import java.util.Scanner;

public class StudentServiceImpl implements StudentService{

    @Override
    public void input(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
    }

    @Override
    public void info(Student student) {
        System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());
    }
}
