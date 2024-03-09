package Model;

import java.util.*;

public class ListExam {
    public List<Person> input() {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
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
                    personList.add(new Person(id, name, age));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return personList;
    }

    public void info(List<Person> personList) {
        int n = personList.size();
        for (int i=0; i<n; i++) {
            System.out.println(personList.get(i).toString());
        }
    }

    public void filter(List<Person> personList) {
        int n = personList.size();
        for (int i=0; i<n; i++) {
            if(personList.get(i).getAge() < 20) System.out.println(personList.get(i).toString());
        }
    }

    public void delete(List<Person> personList) {
        Iterator<Person> it = personList.iterator();
        while(it.hasNext()) {
            Person person = it.next();
            if(person.getName().contains("A")) {
                it.remove();
            }
        }
        info(personList);
    }

    public void sortPerson(List<Person> personList) {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getAge() - person2.getAge();
            }
        });
        info(personList);
    }

}
