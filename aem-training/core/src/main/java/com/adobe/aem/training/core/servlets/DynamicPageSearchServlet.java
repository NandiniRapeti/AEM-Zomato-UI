package com.adobe.aem.training.core.servlets;

import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.paths=/bin/dynamicpagesearch",
        "sling.servlet.methods=GET"
    }
)
public class DynamicPageSearchServlet extends SlingSafeMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicPageSearchServlet.class);
    private static final long serialVersionUID = 1L;

    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Session session = null;

        try {
            session = resourceResolver.adaptTo(Session.class);
            if (session == null) {
                LOG.error("Unable to obtain JCR session from ResourceResolver");
                response.getWriter().write("Session could not be retrieved.");
                return;
            }

            Map<String, String> predicateMap = new HashMap<>();
            predicateMap.put("path", "/content/training/us/en");
            predicateMap.put("type", "cq:Page");
            predicateMap.put("orderby", "@jcr:content/jcr:title");
            predicateMap.put("p.limit", "-1");

            Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), session);
            SearchResult searchResult = query.getResult();

            List<Hit> hits = searchResult.getHits();
            response.getWriter().write("Pages Found:\n");

            for (Hit hit : hits) {
                response.getWriter().write(hit.getPath() + "\n");
            }

        } catch (RepositoryException e) {
            LOG.error("Error while processing the query", e);
            response.getWriter().write("Error occurred: " + e.getMessage());
        } finally {
            if (session != null) {
                session.logout();
            }
        }
    }
}
