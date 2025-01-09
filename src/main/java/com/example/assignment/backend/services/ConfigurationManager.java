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
    private static PropertiesConfiguration propertiesConfiguration;
    private String configPath;
    private boolean isConfigPathSet = false;

    private final SystemConfig systemConfig = new SystemConfig();

    private static  ConfigurationManager instance;

    private ConfigurationManager(){

    }
    public static ConfigurationManager getInstance() throws ConfigurationException {
        // local variable increases performance by 25 percent
        // Joshua Bloch "Effective Java, Second Edition", p. 283-284

        var result = instance;
        // Check if singleton instance is initialized.
        // If it is initialized then we can return the instance.
        if (result == null) {
            // It is not initialized, but we cannot be sure because some other thread might have
            // initialized it in the meanwhile.
            // So to make sure we need to lock on an object to get mutual exclusion.
            synchronized (ConfigurationManager.class) {
                // Again assign the instance to local variable to check if it was initialized by some
                // other thread while current thread was blocked to enter the locked zone.
                // If it was initialized then we can return the previously created instance
                // just like the previous null check.
                result = instance;
                if (result == null) {
                    // The instance is still not initialized, so we can safely
                    // (no other thread can enter this zone)
                    // create an instance and make it our singleton instance.
                    Configurations configs = new Configurations();
                    propertiesConfiguration = configs.properties(new File(DEFAULT_CONFIG_FILE_PATH));
                    result = new ConfigurationManager();
                    instance = result;
                }
            }
        }
        return result;
    }


    public String getConfigPath() {
        return configPath;
    }

//    public void setConfigPath(String configPath) {
//        if(configPath != null && !configPath.isBlank()){
//            this.configPath = configPath;
//            isConfigPathSet = true;
//
//        }
//
//    }


    public boolean isConfigPathSet() {
        return isConfigPathSet;
    }

    public void setConfigPathSet(boolean configPathSet) {
        isConfigPathSet = configPathSet;
    }

    public SystemConfig getConfiguration() throws ConfigurationException {
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
