package com.adobe.aem.demo.project.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

import static com.adobe.cq.wcm.core.components.commons.editor.dialog.childreneditor.Item.LOG;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {
                "/bin/pages",
        }
)
public class DemoPathTypeServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/demo/us/en");
        JSONArray pagesArray = new JSONArray();
        try {
            Iterator<Page> childPages = page.listChildren();
            while (childPages.hasNext()) {
                Page childPage = childPages.next();
                JSONObject pageObject = new JSONObject();
                pageObject.put(childPage.getTitle(), childPage.getPath().toString());
                pagesArray.put(pageObject);
            }
        } catch (JSONException e) {
            LOG.info("\n ERROR {} ", e.getMessage());
        }

        response.setContentType("application/json");
        response.getWriter().write(pagesArray.toString());
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        LOG.info("post is executed...");
        String firstName =  request.getParameter("firstName");
        String lastName =  request.getParameter("lastName");
        response.getWriter().write("First Name : "+firstName + "Last Name" + lastName);
    }
}
