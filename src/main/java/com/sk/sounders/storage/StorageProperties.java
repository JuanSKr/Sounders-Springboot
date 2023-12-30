package com.sk.sounders.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    // getters and setters for the new properties

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}