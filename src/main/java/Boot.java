import comparators.StudentComparator;
import comparators.UniversityComparator;
import comparators.StudentComparators;
import comparators.UniversityComparators;
import reports.*;
import resources.InfoObject;
import resources.ReadResources;
import resources.Student;
import resources.University;
import comparators.ComporatorUtil;
import json.JsonUtil;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Boot {
    private static final Logger logger = Logger.getLogger(Boot.class.getName());
    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(Boot.class.getResourceAsStream("/logging.properties"));
        logger.log(Level.INFO, "Запуск приложения произведен успешно.");
        List<Student> students = ReadResources.readStudents();
        List<University> universities = ReadResources.readUniversities();

        UniversityComparator universityComparator =
                ComporatorUtil.getUniversityComparator(UniversityComparators.YEAR_OF_FOUNDATION_COMPARATOR);
        universities.stream()
                .sorted(universityComparator);

        StudentComparator studentComparator =
                ComporatorUtil.getStudentComparator(StudentComparators.AVG_EXAM_SCORE_COMPARATOR);
        students.stream()
                .sorted(studentComparator);

        students.stream().map(JsonUtil::studentSerialization);
        universities.stream().map(JsonUtil::universitySerialization);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.createAndWriteTableToFile(statisticsList, "src/main/resources/statistics.xlsx");

        InfoObject infoObject = new InfoObject();
        infoObject.setStudentList(students);
        infoObject.setUniversityList(universities);
        infoObject.setStatisticsList(statisticsList);
        infoObject.setCreatedAt(new Date());
        XmlWriter.writeXmlFile(infoObject);
        JsonWriter.writeJsonFile(infoObject);

        logger.log(Level.INFO, "Приложение завершило свою работу.");

    }
}

