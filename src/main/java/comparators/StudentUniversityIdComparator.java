package comparators;

import org.apache.commons.lang3.StringUtils;
import resources.Student;

public class StudentUniversityIdComparator implements StudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return StringUtils.compare(student1.getUniversityId(), student2.getUniversityId());
    }
}
