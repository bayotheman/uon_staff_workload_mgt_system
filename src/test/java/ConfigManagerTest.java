import com.example.assignment.backend.models.SystemConfig;
import com.example.assignment.backend.services.ConfigurationManager;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigManagerTest {

    @Test
    void readConfiguration() throws ConfigurationException {
        ConfigurationManager cm = ConfigurationManager.getInstance();
        SystemConfig stub = cm.getConfiguration();
        SystemConfig config = new SystemConfig();
        config.setIndexStorageLocation("/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment/store/data/index");
        config.setDataStorePath("/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment/store/data");
        config.setStaffStorageLocation("/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment/store/data/staff");
        config.setLogDir("/");

//        Assertions.assertEquals(stub.getDataStorePath(), config.getDataStorePath());
//        Assertions.assertEquals(stub.getLogDir(), config.getLogDir());
        Assertions.assertEquals(config, stub);

    }

    @Test
    void invalidConfigFileTest() throws ConfigurationException {
        //Modify the configPath variable in the ConfigurationManager class to test this method.
       Assertions.assertThrows(Exception.class, ConfigurationManager::getInstance);

    }
}
