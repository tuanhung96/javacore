import Model.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person(1, "Hung", 18);
        Person person2 = new Person(2, "Hieu", 19);
        System.out.println(person1.equals(person2));

        ListExam listExam = new ListExam();
        List<Person> personList = listExam.input();
        listExam.info(personList);
        listExam.filter(personList);
        listExam.delete(personList);
        listExam.sortPerson(personList);

        SetExam setExam = new SetExam();
        Set<Person> personSet = setExam.input();
        setExam.info(personSet);
        setExam.filter(personSet);
        setExam.delete(personSet);

        MainDictionany mainDictionany = new MainDictionany();
        Map<String, Dictionary> map = mainDictionany.input();
        mainDictionany.info(map);
        mainDictionany.filter(map);
        mainDictionany.delete(map);
    }
}