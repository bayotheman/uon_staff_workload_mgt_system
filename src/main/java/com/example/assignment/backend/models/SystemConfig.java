package com.example.assignment.backend.models;


import java.util.Objects;

/**
 * A data structure for System configurations.
 */

public class SystemConfig {

//    private final String home = "/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment";
//    private final String location = home + "/config/config.properties";
//Entity data location

    private  String dataStorePath ;
    private String staffStorageLocation;
    private String indexStorageLocation;

    private String logDir;

    public SystemConfig() {
    }

    public String getLogDir() {
        return logDir;
    }

    public void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    public String getDataStorePath() {
        return dataStorePath;
    }

    public void setDataStorePath(String dataStorePath) {
        this.dataStorePath = dataStorePath;
    }

    public String getStaffStorageLocation() {
        return staffStorageLocation;
    }

    public void setStaffStorageLocation(String staffStorageLocation) {
        this.staffStorageLocation = staffStorageLocation;
    }

    public String getIndexStorageLocation() {
        return indexStorageLocation;
    }

    public void setIndexStorageLocation(String indexStorageLocation) {
        this.indexStorageLocation = indexStorageLocation;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemConfig that = (SystemConfig) o;
        return dataStorePath.equals(that.dataStorePath) && staffStorageLocation.equals(that.staffStorageLocation)
                && indexStorageLocation.equals(that.indexStorageLocation) && logDir.equals(that.logDir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataStorePath, staffStorageLocation, indexStorageLocation, logDir);
    }
}
