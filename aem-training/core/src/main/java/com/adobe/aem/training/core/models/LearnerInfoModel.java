package com.adobe.aem.training.core.models;

import com.adobe.aem.training.core.services.LearnerInfoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LearnerInfoModel {

    @ValueMapValue
    private String idNumber;

    @OSGiService
    private LearnerInfoService learnerInfoService;

    public String getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return learnerInfoService.getLearnerName(idNumber);
    }

    public String getCourse() {
        return learnerInfoService.getLearnerCourse(idNumber);
    }

    public String getMarks() {
        return learnerInfoService.getLearnerMarks(idNumber);
    }

    public String getEmailId() {
        return learnerInfoService.getLearnerEmail(idNumber);
    }

    public String getMinMarks() {
        return learnerInfoService.getMinMarks(idNumber);
    }

    public String getTotalMarks() {
        return learnerInfoService.getTotalMarks(idNumber);
    }

    public String getObtainedMarks() {
        return learnerInfoService.getObtainedMarks(idNumber);
    }

    public String getGrade() {
        return learnerInfoService.getLearnerGrade(idNumber);
    }
}
