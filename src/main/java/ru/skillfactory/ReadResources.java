package ru.skillfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ReadResources {
    static ArrayList<Student> students;
    static ArrayList<University> universities;
    private ReadResources() {}

    public static Iterator<Row> readCatalog(String filePath, String sheetName) {
        try {
            FileInputStream stream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            return iterator;
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        }
        catch (IOException exception) {
            exception.getMessage();
        }
        return null;
    }

    public static ArrayList<Student> readStudents() {
        Iterator iterator = readCatalog("src/main/resources/universityInfo.xlsx", "Студенты");
        while (iterator.hasNext()) {
            if(students == null) {students = new ArrayList<>();}
            Row row = (Row) iterator.next();
            String universityId = row.getCell(0).getStringCellValue();
            String studentName = row.getCell(1).getStringCellValue();
            int courseNumber = (int) row.getCell(2).getNumericCellValue();
            int avgScore = (int) row.getCell(2).getNumericCellValue();
            Student student = new Student(studentName, universityId, courseNumber, avgScore);
            students.add(student);
        }
        return students;
    }

    public static ArrayList<University> readUniversities() {
        Iterator iterator = readCatalog("src/main/resources/universityInfo.xlsx", "Университеты");
        while (iterator.hasNext()) {
            if(universities == null) {universities = new ArrayList<>();}
            Row row = (Row) iterator.next();
            String universityId = row.getCell(0).getStringCellValue();
            String universityFullName = row.getCell(1).getStringCellValue();
            String universityShortName = row.getCell(2).getStringCellValue();
            int universityYearOfFoundation = (int) row.getCell(3).getNumericCellValue();
            String profile = row.getCell(4).getStringCellValue();
            try {
                StudyProfile mainProfile = StudyProfile.valueOf(profile);
                University university = new University(universityId, universityFullName, universityShortName,
                        universityYearOfFoundation, mainProfile);
                universities.add(university);
            } catch (IllegalArgumentException ex) {
                System.out.println("Профиль " + profile + " отсутствует в перечислении. Объект университета не был создан.");
            }
        }
        return universities;
    }
}
