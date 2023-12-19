package com.adobe.aem.demo.project.core.models.impl;

import com.adobe.aem.demo.project.core.models.CustomComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.models.factory.ModelFactory;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {CustomComponent.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomComponentImpl implements CustomComponent{

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private ModelFactory modelFactory;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    @ChildResource
    private Resource file;

    @ValueMapValue
    private String fileReference;




//    @PostConstruct
//    private void init() {
//        image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
//    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isEmpty() {
//        final Image componentImage = getImage();

//        if (StringUtils.isBlank(name)) {
//            // Name is missing, but required
//            return true;
//        } else if (occupations == null || occupations.isEmpty()) {
//            // At least one occupation is required
//            return true;
//        } else if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
//            // A valid image is required
//            return true;
//        } else {
//            // Everything is populated, so this component is not considered empty
//            return false;
//        }
        return false;
    }

    @Override
    public String getFile() {
        return file.getPath();
    }

    @Override
    public String getFileReference() {
        return fileReference;
    }
}
