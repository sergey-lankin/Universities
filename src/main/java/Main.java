package ru.skillfactory;

import ru.skillfactory.resources.ReadResources;
import ru.skillfactory.resources.Student;
import ru.skillfactory.resources.University;
import ru.skillfactory.comparators.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = ReadResources.readStudents();
/*        System.out.println("Студенты:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
*/
        List<University> universities = ReadResources.readUniversities();
/*         System.out.println("Университеты:");
        for (University university : universities) {
            System.out.println(university.toString());
        }
*/
        UniversityComparator universityComparator = ComporatorUtil.getUniversityComparator(UniversityComparators.FULL_NAME_COMPARATOR);
        StudentComparator studentComparator = ComporatorUtil.getStudentComparator(StudentComparators.AVG_EXAM_SCORE_COMPARATOR);
        universities.stream()
                .sorted()
                .forEach(System.out::println);
        students.stream()
                .sorted()
                .forEach(System.out::println);
    }
}