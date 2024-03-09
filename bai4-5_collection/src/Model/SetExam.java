package Model;

import java.util.*;

public class SetExam {
    public Set<Person> input() {
        Scanner sc = new Scanner(System.in);
        Set<Person> personSet = new HashSet<>();
        while(true) {
            System.out.println("0. Exit");
            System.out.print("Nhap so luong person: ");
            try{
                int n = sc.nextInt();
                if(n == 0) break;
                for(int i=0; i<n; i++) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    personSet.add(new Person(id, name, age));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return personSet;
    }

    public void info(Set<Person> personSet) {
        for (Person person : personSet) {
            System.out.println(person.toString());
        }
    }

    public void filter(Set<Person> personSet) {
        for (Person person : personSet) {
            if(person.getAge() < 20) System.out.println(person.toString());
        }
    }

    public void delete(Set<Person> personSet) {
        Iterator<Person> it = personSet.iterator();
        while(it.hasNext()) {
            Person person = it.next();
            if(person.getName().contains("A")) {
                it.remove();
            }
        }
        info(personSet);
    }

}
