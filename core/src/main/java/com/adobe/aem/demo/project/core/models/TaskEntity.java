package com.adobe.aem.demo.project.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TaskEntity {

     @ValueMapValue
     String number;
     @ValueMapValue
     String fileReference;
     @ValueMapValue
     String title;
     @ValueMapValue
     String subtitle;
     @ValueMapValue
     String description;

     public String getNumber() {
          return number;
     }

     public String getFileReference() {
          return fileReference;
     }

     public String getTitle() {
          return title;
     }

     public String getSubtitle() {
          return subtitle;
     }

     public String getDescription() {
          return description;
     }
}
