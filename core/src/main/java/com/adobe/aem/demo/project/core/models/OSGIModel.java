package com.adobe.aem.demo.project.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;
import javax.xml.validation.Validator;

@Model(adaptables = Resource.class)
public class OSGIModel {

    @OSGiService
    private OSGIConfig osgiConfig;

    @Self
    Resource resource;

    private String customFieldValue;


    @PostConstruct
    public void init() {
        PageManager pm = resource.getResourceResolver().adaptTo(PageManager.class);
        if(pm!=null) {
            Page containingPage = pm.getContainingPage (resource);
            ValueMap pageProperties = containingPage.getProperties();
            customFieldValue = (String) pageProperties.get("text");
        }

    }


    public String getCustomFieldValue() {
        return customFieldValue;
    }

    public String getMyActivity() {
        return osgiConfig.getRandomActivity();
    }
}
