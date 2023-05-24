package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ReadResources {
    static ArrayList<Student> students;
    static ArrayList<University> universities;
    public static final Logger logger = Logger.getLogger(ReadResources.class.getName());
    private ReadResources() {}

    public static Iterator<Row> readCatalog(String filePath, String sheetName) {
        try {
            FileInputStream stream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            logger.log(Level.INFO, "Файл прочитан успешно.");
            return iterator;
        } catch (FileNotFoundException exception) {
            logger.log(Level.SEVERE, "Файл с информацией об университетах отсутствует!");
            exception.getMessage();
        }
        catch (IOException exception) {
            logger.log(Level.SEVERE, "Ошибка формирования потока! Проверьте корректность формата файла.");
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
        logger.log(Level.INFO, "Коллекция студентов сформирована.");
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
                logger.log(Level.WARNING, "В перечислении отсутсвует требуемый профиль образования. Выберите доступный.");
            }
        }
        logger.log(Level.INFO, "Коллекция университетов сформирована.");
        return universities;
    }
}
