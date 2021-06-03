package pt.ual.pp.lab6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class StudentRecord{
    private int id;
    private String name;
    private int grade;

    public StudentRecord(int id, String name, int grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getGrade(){
        return this.grade;
    }

    @Override
    public String toString(){
        return getId() + " " + getName();
    }

}

class PrintConsumer implements Consumer<StudentRecord>{
    @Override
    public void accept(StudentRecord studentRecord) {
        System.out.println(studentRecord.getId() + " " + studentRecord.getGrade());
    }
}

class SelectRecord implements Predicate<Integer>{

    @Override
    public boolean test(Integer i) {
        return i < 10;
    }
}

public class App 
{
    public static void main( String[] args )
    {
        List<StudentRecord> studentRecordList = Arrays.asList(
                new StudentRecord(1, "Alice", 14),
                new StudentRecord(2, "Trudy", 17),
                new StudentRecord(3, "Bob", 8),
                new StudentRecord(4, "Anna", 12),
                new StudentRecord(5, "James", 15)

        );

        //c)
        System.out.println("\nc) first implementation");
        Iterator<StudentRecord> iterator = studentRecordList.iterator();
        while(iterator.hasNext()){
            StudentRecord studentRecord = iterator.next();
            new PrintConsumer().accept(studentRecord);
        }

        System.out.println("\nc) second implementation");
        studentRecordList.stream().forEach(s -> new PrintConsumer().accept(s));

        //d)
        System.out.println("\nd)");
        studentRecordList.stream().filter(s -> new SelectRecord().test(s.getGrade())).forEach(System.out::println);

    }
}
