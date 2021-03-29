package net.lwenstrom.studentWebService;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import net.lwenstrom.ws.students.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    private static final Map<Integer, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() throws DatatypeConfigurationException {
        Student jan = new Student();
        jan.setName("Jan");
        jan.setSurname("Löwenstrom");
        jan.setStudentID(34937);
        jan.setAvgScore(1.18);
        jan.setBirthday(
                DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(1994, 1, 25).toString())
);
        jan.setIban("DE59 1000 000 0323 1022");
        jan.setPlz(24754);
        jan.setStreet("Mundsburger Straße 233");
        jan.setCity("Hamburg");

        students.put(jan.getStudentID(), jan);

        Student rixta = new Student();
        rixta.setName("Roxta");
        rixta.setSurname("Padehkenn");
        rixta.setStudentID(33333);
        rixta.setAvgScore(1.0);
        rixta.setBirthday(
                DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(1993, 2, 5).toString())
        );
        rixta.setIban("DE38 3999 0000 1002 3425") ;
        rixta.setPlz(63065);
        rixta.setStreet("Sesamstraße 502");
        rixta.setCity("Offenbach");
        students.put(rixta.getStudentID(), rixta);


        Student kristin = new Student();
        kristin.setName("Krischtin");
        kristin.setSurname("Woarnz");
        kristin.setStudentID(42382);
        kristin.setAvgScore(1.7);
        kristin.setBirthday(
                DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(1994, 10, 15).toString())
        );
        kristin.setIban("DE22 2041 0000 2220 8541");
        kristin.setPlz(80331);
        kristin.setStreet("Turmstraße 69");
        kristin.setCity("München");
        students.put(kristin.getStudentID(), kristin);

    }

    public Student findStudent(int studentID) {
        return students.get(studentID);
    }
}
