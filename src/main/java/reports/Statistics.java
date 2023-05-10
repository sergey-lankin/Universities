package reports;

import resources.StudyProfile;

import java.util.List;

public class Statistics {
    private StudyProfile studyProfile;
    private long avgExamScore;
    private int studentsQuantity;
    private int universitiesQuantity;
    private String universitiesNames;

    public Statistics() {
    }
    public Statistics(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public long getAvgExamScore() {
        return avgExamScore;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public int getUniversitiesQuantity() {
        return universitiesQuantity;
    }

    public String getUniversitiesNames() {
        return universitiesNames;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public void setAvgExamScore(long avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public void setUniversitiesQuantity(int universitiesQuantity) {
        this.universitiesQuantity = universitiesQuantity;
    }

    public void setUniversitiesNames(String universitiesNames) {
        this.universitiesNames = universitiesNames;
    }
}

