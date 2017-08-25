package queries;

import entity.Student;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class Runner {

    public static void main(String[] args) {
        Queries q = new Queries();

        List<Student> list1 = q.findAllStudents();
        for (Student s1 : list1) {
            System.out.println(s1.getFirstname() + " " + s1.getLastname());
        }
        System.out.println("THIS WAS ALL STUDENTS");

        List<Student> list2 = q.findAnders();
        for (Student s2 : list2) {
            System.out.println(s2.getFirstname() + " " + s2.getLastname());
        }
        System.out.println("THIS WAS ALL ANDERS");

        Student s1 = new Student();
        s1.setFirstname("Kasper");
        s1.setLastname("Ravn");
        Student s = q.createStudent(s1);
        System.out.println(s.getFirstname());

        List<Student> list3 = q.findAnd();
        for (Student s3 : list3) {
            System.out.println(s3.getFirstname() + " " + s3.getLastname());
        }
        System.out.println("THIS WAS ALL AND");

        q.assignToSemester("Kasper", "CLcos-v14e");
        String semName = "CLcos-v14e";
        System.out.println("Sum of students from semester: " + semName + " is: " + q.sumStudentsForSemester(semName));
        System.out.println("Sum of students from all semesters: " + q.sumStudentsAllSemesters());
        System.out.println("THe teacher who is active in most semesters is: " + q.teacherMostActive().getFirstname());
    }

}
