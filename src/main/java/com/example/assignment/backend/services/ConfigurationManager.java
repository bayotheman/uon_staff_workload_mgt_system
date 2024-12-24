package com.example.assignment.backend.services;

import com.example.assignment.backend.models.SystemConfig;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

/**
 * A Singleton class that manages the system's configuration file
 * @author Adebayo. A. Okutubo
 */
public class ConfigurationManager {
    private static final String DEFAULT_CONFIG_FILE_PATH = "/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment/config/config.properties";
    private final PropertiesConfiguration propertiesConfiguration;
    private String configPath;
    private boolean isConfigPathSet = false;

    private final SystemConfig systemConfig = new SystemConfig();


    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        if(configPath != null && !configPath.isBlank()){
            this.configPath = configPath;
            isConfigPathSet = true;

        }

    }

    public boolean isConfigPathSet() {
        return isConfigPathSet;
    }

    public void setConfigPathSet(boolean configPathSet) {
        isConfigPathSet = configPathSet;
    }

    public ConfigurationManager(String configPath) throws ConfigurationException {
        Configurations configs = new Configurations();
        propertiesConfiguration = configs.properties(new File(configPath));
        isConfigPathSet = true;
    }

    public ConfigurationManager() throws ConfigurationException {
        Configurations configs = new Configurations();
        propertiesConfiguration = configs.properties(new File(DEFAULT_CONFIG_FILE_PATH));
    }



    public SystemConfig readConfiguration() throws ConfigurationException {
//        SystemConfig systemConfig = new SystemConfig();
        // Access properties
        try{
        systemConfig.setDataStorePath(propertiesConfiguration.getString("data.storage.path"));
        systemConfig.setIndexStorageLocation(propertiesConfiguration.getString("index.storage.path"));
        systemConfig.setStaffStorageLocation(propertiesConfiguration.getString("staff.storage.path"));
        systemConfig.setLogDir(propertiesConfiguration.getString("log.dir.path"));
        }catch (Exception e){
            throw new ConfigurationException("property not found in config file. Configuration file has been modified kindly add this property");
        }

        return systemConfig;
    }
}
