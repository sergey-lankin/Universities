package reports;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    public static void createAndWriteTableToFile(List<Statistics> statisticsList, String pathToFile) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");
        Row header = sheet.createRow(0);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        Cell header0 = header.createCell(0);
        header0.setCellValue("Study Profile");
        header0.setCellStyle(headerStyle);
        Cell header1 = header.createCell(1);
        header1.setCellValue("Average Exam Score");
        header1.setCellStyle(headerStyle);
        Cell header2 = header.createCell(2);
        header2.setCellValue("Students Quantity");
        header2.setCellStyle(headerStyle);
        Cell header3 = header.createCell(3);
        header3.setCellValue("Universities Quantity");
        header3.setCellStyle(headerStyle);
        Cell header4 = header.createCell(4);
        header4.setCellValue("Universities Names");
        header4.setCellStyle(headerStyle);

        int i = 0;
        for (Statistics statistics : statisticsList) {
            i++;
            Row currentStat = sheet.createRow(i);
            currentStat.createCell(0).setCellValue(statistics.getStudyProfile().profileName);
            currentStat.createCell(1).setCellValue(statistics.getAvgExamScore());
            currentStat.createCell(2).setCellValue(statistics.getStudentsQuantity());
            currentStat.createCell(3).setCellValue(statistics.getUniversitiesQuantity());
            currentStat.createCell(4).setCellValue(statistics.getUniversitiesNames());
        }
        try {
            FileOutputStream stream = new FileOutputStream(pathToFile);
            workbook.write(stream);
        } catch (FileNotFoundException exception) {
            exception.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
