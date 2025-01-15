package com.adobe.aem.training.core.services;

public interface LearnerInfoService {
    String getLearnerName(String idNumber);
    String getLearnerCourse(String idNumber);
    String getLearnerMarks(String idNumber);
    String getLearnerEmail(String idNumber);
    String getMinMarks(String idNumber);
    String getTotalMarks(String idNumber);
    String getObtainedMarks(String idNumber);
    String getLearnerGrade(String idNumber);

    // Add this method if not already present
    String getLearnerRollNumber(String idNumber);
}