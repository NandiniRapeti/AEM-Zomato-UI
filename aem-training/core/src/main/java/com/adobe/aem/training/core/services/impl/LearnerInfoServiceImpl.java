package com.adobe.aem.training.core.services.impl;

import com.adobe.aem.training.core.services.LearnerInfoService;
import org.osgi.service.component.annotations.Component;

@Component(service = LearnerInfoService.class, immediate = true)
public class LearnerInfoServiceImpl implements LearnerInfoService {

    private static final Learner[] LEARNERS = {
        new Learner("101", "Nandini", "Mathematics", "88", "nandini@example.com", "40", "100", "88", "A"),
        new Learner("102", "Eshitha", "Science", "92", "eshitha@example.com", "40", "100", "92", "C"),
        new Learner("103", "Nikitha", "History", "85", "nikitha@example.com", "40", "100", "85", "B"),
    };

    @Override
    public String getLearnerName(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getName() : "Not found";
    }

    @Override
    public String getLearnerCourse(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getCourse() : "Not found";
    }

    @Override
    public String getLearnerMarks(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getMarks() : "Not found";
    }

    @Override
    public String getLearnerEmail(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getEmail() : "Not found";
    }

    @Override
    public String getMinMarks(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getMinMarks() : "Not found";
    }

    @Override
    public String getTotalMarks(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getTotalMarks() : "Not found";
    }

    @Override
    public String getObtainedMarks(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getObtainedMarks() : "Not found";
    }

    @Override
    public String getLearnerGrade(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getGrade() : "Not found";
    }

    @Override
    public String getLearnerRollNumber(String idNumber) {
        Learner learner = findLearnerById(idNumber);
        return learner != null ? learner.getIdNumber() : "Not found";
    }

    private Learner findLearnerById(String idNumber) {
        for (Learner learner : LEARNERS) {
            if (learner.getIdNumber().equals(idNumber)) {
                return learner;
            }
        }
        return null;
    }

    private static class Learner {
        private final String idNumber, name, course, marks, email, minMarks, totalMarks, obtainedMarks, grade;

        public Learner(String idNumber, String name, String course, String marks, String email, String minMarks, String totalMarks, String obtainedMarks, String grade) {
            this.idNumber = idNumber;
            this.name = name;
            this.course = course;
            this.marks = marks;
            this.email = email;
            this.minMarks = minMarks;
            this.totalMarks = totalMarks;
            this.obtainedMarks = obtainedMarks;
            this.grade = grade;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public String getName() {
            return name;
        }

        public String getCourse() {
            return course;
        }

        public String getMarks() {
            return marks;
        }

        public String getEmail() {
            return email;
        }

        public String getMinMarks() {
            return minMarks;
        }

        public String getTotalMarks() {
            return totalMarks;
        }

        public String getObtainedMarks() {
            return obtainedMarks;
        }

        public String getGrade() {
            return grade;
        }
    }
}
