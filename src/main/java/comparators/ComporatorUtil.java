package comparators;

public class ComporatorUtil {
    private ComporatorUtil() {};
    public static StudentComparator getStudentComparator(StudentComparators studentComparator) {
        switch (studentComparator) {
            case AVG_EXAM_SCORE_COMPARATOR:
                return new StudentAvgExamScoreComparator();
            case CURRENT_COURSE_COMPARATOR:
                return new StudentCurrentCourseNumberComparator();
            case FULL_NAME_COMPARATOR:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID_COMPARATOR:
                return new StudentUniversityIdComparator();
            default: return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators universityComparator) {
        switch (universityComparator) {
            case FULL_NAME_COMPARATOR:
                return new UniversityFullNameComparator();
            case ID_COMPARATOR:
                return new UniversityIdComparator();
            case MAIN_PROFILE_COMPARATOR:
                return new UniversityMainProfileComparator();
            case SHORT_NAME_COMPARATOR:
                return new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION_COMPARATOR:
                return new UniversityYearOfFoundationComparator();
            default: return new UniversityFullNameComparator();
        }
    }
}
