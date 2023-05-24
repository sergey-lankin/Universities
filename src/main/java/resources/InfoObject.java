package resources;

import reports.Statistics;
import jakarta.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoObject {
    @XmlElement(name = "studentEntry")
    @XmlElementWrapper(name = "studentsInfo")
    List<Student> studentList;
    @XmlElement(name = "universityEntry")
    @XmlElementWrapper(name = "universitiesInfo")
    List<University> universityList;
    @XmlElement(name = "statisticsEntry")
    @XmlElementWrapper(name = "statisticalInfo")
    List<Statistics> statisticsList;
    @XmlElement(name = "processedAt")
    Date createdAt;
    public InfoObject() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

