package reports;

import org.apache.commons.lang3.StringUtils;
import resources.Student;
import resources.StudyProfile;
import resources.University;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {
    List<Student> students;
    List<University> universities;
    private StatisticsUtil() {
    }
    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> studyProfileSet = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        studyProfileSet.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);

        List<String> universitiesIds = universities.stream()
                .filter(university -> university.getMainProfile().equals(profile))
                .map(University::getId)
                .collect(Collectors.toList());
        statistics.setUniversitiesQuantity(universitiesIds.size());
        statistics.setUniversitiesNames(StringUtils.EMPTY);

        universities.stream()
                .filter(university -> universitiesIds.contains(university.getId()))
                .map(University::getFullName)
                .forEach(universityFullName -> statistics.setUniversitiesNames(
                        statistics.getUniversitiesNames() + "'" + universityFullName + "' "));
        List<Student> profileStudents = students.stream()
                .filter(student -> universitiesIds.contains(student.getUniversityId()))
                .collect(Collectors.toList());
        statistics.setStudentsQuantity(profileStudents.size());
        OptionalDouble averageScore = profileStudents.stream()
                .mapToDouble(Student::getAvgExamScore)
                .average();
        statistics.setAvgExamScore(0);
        averageScore.ifPresent(avgScore -> statistics.setAvgExamScore(
                (long) BigDecimal.valueOf(avgScore).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticsList;
    }
}
