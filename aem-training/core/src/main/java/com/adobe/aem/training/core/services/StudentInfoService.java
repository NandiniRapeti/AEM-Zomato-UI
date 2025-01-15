package com.adobe.aem.training.core.services;
 
public interface StudentInfoService {
    String getStudentName(String rollNumber);
    String getStudentSubject(String rollNumber);
    String getStudentMarks(String rollNumber);
}