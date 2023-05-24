package reports;

import json.JsonUtil;
import resources.InfoObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());
    private JsonWriter() {
    }
    public static void writeJsonFile(InfoObject infoObject) {
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Директория jsonReqs создана успешно.");
        } catch (IOException exception) {
            logger.log(Level.WARNING, "Директория jsonReqs уже существует.");
        }
        
        writeJsonStudents(infoObject);
        writeJsonUniversities(infoObject);
        writeJsonStatistics(infoObject);
        logger.log(Level.INFO, "Запись файлов json произведена успешно.");
    }

    private static void writeJsonStudents(InfoObject infoObject) {
        String studentsJson = JsonUtil.studentListSerialization(infoObject.getStudentList());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/students" +
                    new Date().getTime() + ".json");
            fileOutputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи json-файла студентов.", e);
        }
    }
    private static void writeJsonUniversities(InfoObject infoObject) {
        String universitiesJson = JsonUtil.universityListSerialization(infoObject.getUniversityList());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/universities" +
                    new Date().getTime() + ".json");
            fileOutputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи json-файла университетов.", e);
        }
    }
    private static void writeJsonStatistics(InfoObject infoObject) {
        String statisticsJson = JsonUtil.statisticsListSerialization(infoObject.getStatisticsList());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("jsonReqs/statistics" +
                    new Date().getTime() + ".json");
            fileOutputStream.write(statisticsJson.getBytes());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи json-файла статистики.", e);
        }
    }
}
