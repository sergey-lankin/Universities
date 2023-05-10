import comparators.StudentComparator;
import comparators.UniversityComparator;
import comparators.StudentComparators;
import comparators.UniversityComparators;
import reports.Statistics;
import reports.StatisticsUtil;
import reports.XlsWriter;
import resources.ReadResources;
import resources.Student;
import resources.University;
import comparators.ComporatorUtil;
import json.JsonUtil;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Boot {

    public static void main(String[] args) throws IOException {

        List<Student> students = ReadResources.readStudents();
        List<University> universities = ReadResources.readUniversities();
        String jsonStudents = JsonUtil.studentListSerialization(students);
        String jsonUniversities = JsonUtil.universityListSerialization(universities);
        System.out.println(jsonStudents);
        System.out.println(jsonUniversities);
        List<Student> newStudents = JsonUtil.studentListDeserialization(jsonStudents);
        List<University> newUniversities = JsonUtil.universityListDeserialization(jsonUniversities);

        if (newStudents.size() == students.size()) {System.out.println("Коллекция студентов десерелизована корректно");}
        else {System.out.println("Коллекция студентов десерелизована некорректно");}
        if (newUniversities.size() == universities.size()) {System.out.println("Коллекция университетов десерелизована корректно");}
        else {System.out.println("Коллекция университетов десерелизована некорректно");}

        students.stream()
                .map(JsonUtil::studentSerialization)
                .forEach(jsonStudent -> {
                    System.out.println(jsonStudent);
                    System.out.println(JsonUtil.studentDeserialization(jsonStudent));
        });

        universities.stream()
                .map(JsonUtil::universitySerialization)
                .forEach(jsonUniversity -> {
                    System.out.println(jsonUniversity);
                    System.out.println(JsonUtil.universityDeserialization(jsonUniversity));
                });

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.createAndWriteTableToFile(statisticsList, "src/main/resources/statistics.xlsx");
    }
}

