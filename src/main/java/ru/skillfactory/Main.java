package ru.skillfactory;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = ReadResources.readStudents();
        System.out.println("Студенты:");
        for (Student student : students) {
            System.out.println(student.toString());
        }

        ArrayList<University> universities = ReadResources.readUniversities();
        System.out.println("Университеты:");
        for (University university : universities) {
            System.out.println(university.toString());
        }
    }
}