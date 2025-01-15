package com.adobe.aem.training.core.models;
 
import com.adobe.aem.training.core.services.StudentInfoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
 
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class StudentInfoModel {
 
    @ValueMapValue
    private String rollNumber;
 
    @OSGiService
    private StudentInfoService studentInfoService;
 
    public String getRollNumber() {
        return rollNumber;
    }
 
    public String getName() {
        return studentInfoService.getStudentName(rollNumber);
    }
 
    public String getSubject() {
        return studentInfoService.getStudentSubject(rollNumber);
    }
 
    public String getMarks() {
        return studentInfoService.getStudentMarks(rollNumber);
    }
}