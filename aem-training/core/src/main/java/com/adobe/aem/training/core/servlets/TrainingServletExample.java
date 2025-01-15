package com.adobe.aem.training.core.servlets;
 
import java.io.IOException;
 
import javax.servlet.Servlet;
import javax.servlet.ServletException;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
 
@Component (immediate=true,
service=Servlet.class,
property= {
        "sling.servlet.paths=/bin/trainingservlet",
        "sling.servlet.methods=GET"
}
)
public class TrainingServletExample extends SlingSafeMethodsServlet{
 
    private static final long serialVersionUID =1L;
 
    @Override
    protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response)throws ServletException,IOException
    {
        response.getWriter().write("thanks");
    }
}
