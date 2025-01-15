package com.adobe.aem.training.core.services.impl;
 
import com.adobe.aem.training.core.services.StudentInfoService;
import org.osgi.service.component.annotations.Component;
 
import java.util.HashMap;
import java.util.Map;
 
@Component(service = StudentInfoService.class, immediate = true)
public class StudentInfoServiceImpl implements StudentInfoService {
 
    private static final Map<String, Student> STUDENT_DATA = new HashMap<>();
 
    static {
        STUDENT_DATA.put("101", new Student("Nandini", "Mathematics", "88"));
        STUDENT_DATA.put("102", new Student("Eshitha", "Science", "92"));
        STUDENT_DATA.put("103", new Student("Nikitha", "History", "85"));
        STUDENT_DATA.put("104", new Student("Manaswini", "Geography", "90"));
        STUDENT_DATA.put("105", new Student("Sirisha", "Physics", "87"));
        STUDENT_DATA.put("106", new Student("Divya", "Chemistry", "91"));
        STUDENT_DATA.put("107", new Student("Harshith", "Biology", "89"));
        STUDENT_DATA.put("108", new Student("Radhika", "English", "93"));
        STUDENT_DATA.put("109", new Student("Srikanth", "Mathematics", "86"));
        STUDENT_DATA.put("110", new Student("Sampath", "Science", "94"));
        STUDENT_DATA.put("111", new Student("Devi", "History", "84"));
        STUDENT_DATA.put("112", new Student("Prathyusha", "Geography", "92"));
        STUDENT_DATA.put("113", new Student("Hussain", "Physics", "89"));
        STUDENT_DATA.put("114", new Student("Rushikesh", "Chemistry", "90"));
        STUDENT_DATA.put("115", new Student("Sahil", "Biology", "88"));
        STUDENT_DATA.put("116", new Student("Pavitra", "English", "91"));
        STUDENT_DATA.put("117", new Student("Snihitha", "Mathematics", "87"));
        STUDENT_DATA.put("118", new Student("Gopal", "Science", "93"));
        STUDENT_DATA.put("119", new Student("Sivani", "History", "85"));
        STUDENT_DATA.put("120", new Student("Sravani", "Geography", "90"));
    }
 
    @Override
    public String getStudentName(String rollNumber) {
        Student student = STUDENT_DATA.get(rollNumber);
        return student != null ? student.getName() : "Not found";
    }
 
    @Override
    public String getStudentSubject(String rollNumber) {
        Student student = STUDENT_DATA.get(rollNumber);
        return student != null ? student.getSubject() : "Not found";
    }
 
    @Override
    public String getStudentMarks(String rollNumber) {
        Student student = STUDENT_DATA.get(rollNumber);
        return student != null ? student.getMarks() : "Not found";
    }
 
    private static class Student {
        private final String name;
        private final String subject;
        private final String marks;
 
        public Student(String name, String subject, String marks) {
            this.name = name;
            this.subject = subject;
            this.marks = marks;
        }
 
        public String getName() {
            return name;
        }
 
        public String getSubject() {
            return subject;
        }
 
        public String getMarks() {
            return marks;
        }
    }
}