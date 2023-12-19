package com.adobe.aem.demo.project.core.models.impl;

import com.adobe.aem.demo.project.core.models.TaskComponent;
import com.adobe.aem.demo.project.core.models.TaskEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(
        adaptables = Resource.class,
        adapters = TaskComponent.class,
        resourceType = TaskComponentImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
//@Exporter(name = "jackson", extensions = "json")
public class TaskComponentImpl implements TaskComponent {

    static final String RESOURCE_TYPE = "demo/components/task_6-component";

    @Self
    protected Resource resource;

    @ChildResource
    List<TaskEntity> contact;

    @Override
    public List<TaskEntity> getContact() {
            return contact;
    }

//    @JsonProperty
//    public String hello() {
//        return "Hello world";
//    }
}
