package comparators;

import reports.StatisticsUtil;
import resources.Student;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student1.getAvgExamScore(), student2.getAvgExamScore()) * -1;
    }
}
