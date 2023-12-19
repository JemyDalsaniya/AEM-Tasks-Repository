package com.adobe.aem.demo.project.core.models;

import org.apache.sling.api.resource.Resource;

import java.util.List;

public interface CustomComponent {

    String getName();
    List<String> getOccupations();

    boolean isEmpty();

    String getFile();

    String getFileReference();
}
