package json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import resources.Student;
import resources.University;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {};
    public static String studentSerialization(Student student) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String studentJson = gson.toJson(student);
        return studentJson;
    }
    public static String universitySerialization(University university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String universityJson = gson.toJson(university);
        return universityJson;
    }

    public static String studentListSerialization(List<Student> students) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String studentJson = gson.toJson(students);
        return studentJson;
    }
    public static String universityListSerialization(List<University> universities) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String universityJson = gson.toJson(universities);
        return universityJson;
    }
    public static Student studentDeserialization(String studentJson) {
        Gson gson = new GsonBuilder().create();
        Student student = gson.fromJson(studentJson, Student.class);
        return student;
    }
    public static University universityDeserialization(String universityJson) {
        Gson gson = new GsonBuilder().create();
        University university = gson.fromJson(universityJson, University.class);
        return university;
    }

    public static List<Student> studentListDeserialization(String studentListJson) {
        Gson gson = new GsonBuilder().create();
        List<Student> students = gson.fromJson(studentListJson, List.class);
        return students;
    }

    public static List<University> universityListDeserialization(String universityListJson) {
        Gson gson = new GsonBuilder().create();
        List<University> universities = gson.fromJson(universityListJson, List.class);
        return universities;
    }
}
