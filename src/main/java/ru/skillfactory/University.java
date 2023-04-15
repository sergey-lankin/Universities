package ru.skillfactory;

public class University {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;
    private int quantityOfCampuses;
    private int rating;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation,
                      StudyProfile mainProfile, int quantityOfCampuses, int rating) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
        this.quantityOfCampuses = quantityOfCampuses;
        this.rating = rating;
    }

    public University(String id, String fullName, String shortName,
                      int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public int getQuantityOfCampuses() {
        return quantityOfCampuses;
    }

    public void setQuantityOfCampuses(int quantityOfCampuses) {
        this.quantityOfCampuses = quantityOfCampuses;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
enum StudyProfile {
    PHYSICS ("Физика"),
    CHEMISTRY ("Химия"),
    MEDICINE ("Медицина"),
    ECONOMY ("Экономика"),
    LINGUISTICS ("Лингвистика"),
    MATHEMATICS ("Математика"),
    MULTI ("Многопрофильный");
    public final String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
