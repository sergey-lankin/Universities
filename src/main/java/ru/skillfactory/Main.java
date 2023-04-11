package ru.skillfactory;

public class Main {
    public static void main(String[] args) {
        University mgu = new University();
        mgu.setShortName("MGU");
        mgu.setId("mgu");
        mgu.setFullName("Moskovsky Gosudarstvenny Universitet imeni Lomonosova");
        mgu.setRating(10);
        mgu.setQuantityOfCampuses(2);
        mgu.setYearOfFoundation(1755);
        mgu.setMainProfile(StudyProfile.MULTI);

        Student sergey = new Student();
        sergey.setFullName("Sergey Petroff");
        sergey.setAvgExamScore(4.23f);
        sergey.setDepartment("Nuclear Physics");
        sergey.setUniversityId("bauman");
        sergey.setCurrentCourseNumber(1);

        System.out.println(mgu);
        System.out.println(sergey);
    }
}