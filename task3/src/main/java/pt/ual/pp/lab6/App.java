package pt.ual.pp.lab6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Person{
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return id + "=Person(" + getId() + ", " + getName() + ", " + getAge()+")";
    }

}

public class App 
{
    public static void main( String[] args )
    {
        List<Person> people = Arrays.asList(
                new Person("1", "Alice", 28),
                new Person("2", "Trudy", 32),
                new Person("3", "Anna", 24),
                new Person("4", "Bob", 40),
                new Person("5", "James", 18)
        );

        //a)
        System.out.println(
                //people.stream().filter(person -> person.getAge() >= (people.stream().mapToInt(Person::getAge).sum() / people.size())).count()
                people.stream().filter(person -> person.getAge() > (people.stream().mapToInt(Person::getAge).average().getAsDouble())).count()
        );

        //b)
        System.out.println(
           Math.sqrt( (people.stream().mapToDouble(p -> Math.pow( p.getAge() - (people.stream().mapToInt(Person::getAge).average().getAsDouble()),2 )).sum()) / people.size())
        );

//        System.out.println(
//                Math.sqrt(people.stream().mapToDouble(person ->
//                        Math.pow(person.getAge() - (people.stream().
//                                mapToInt(Person::getAge).sum() / people.size()), 2)).sum() / people.size())
//        );

        //c)
        Map<String, Person> personMap = people.stream().collect(Collectors.toMap(p -> p.getId(), p -> p));
        System.out.println("\nFirst method");
        personMap.forEach((id, person) -> System.out.println(id + "=Person(" + person.getId() + ", " + person.getName() + ", " + person.getAge()+")"));
        System.out.println("\nSecond method");
        personMap.values().forEach(System.out::println);
        System.out.println("\nThird method");
        personMap.entrySet().forEach(e -> System.out.println(e.getKey() + "=Person(" + e.getValue().getId() + ", " + e.getValue().getName() + ", " + e.getValue().getAge()+")"));

    }
}
