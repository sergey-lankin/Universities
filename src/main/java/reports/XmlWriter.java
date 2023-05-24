package reports;

import resources.InfoObject;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());
    private XmlWriter() {
    }
    public static void writeXmlFile(InfoObject infoObject) {

        try {
            logger.log(Level.INFO, "Запись файла XML запущена успешно.");
            JAXBContext jaxbContext = JAXBContext.newInstance(InfoObject.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Директория xmlReqs создана успешно.");
            } catch (IOException exception) {
                logger.log(Level.WARNING, "Директория xmlReqs уже существует.");
            }
            File xmlFile = new File("xmlReqs/Info" + new Date().getTime() + ".xml");
            marshaller.marshal(infoObject, xmlFile);
            logger.log(Level.INFO, "Файл записан успешно.");
        } catch (JAXBException exception) {
            logger.log(Level.SEVERE, "Ошибка процесса сборки XML.", exception);
        }
    }
}
