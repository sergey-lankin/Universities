package resources;

public enum StudyProfile {
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
