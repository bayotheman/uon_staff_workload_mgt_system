import com.example.assignment.backend.models.Activity;
import com.example.assignment.backend.models.ActivityType;
import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.models.staff.Staff;
import com.example.assignment.backend.repository.StaffStorageRepository;
import com.example.assignment.backend.services.ConfigurationManager;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class StaffStorageRepositoryTest {

    static StaffStorageRepository staffStorageRepository;

    @BeforeAll
    public static void init() throws ConfigurationException {
        ConfigurationManager  configurationManager = new ConfigurationManager();
        staffStorageRepository = new StaffStorageRepository(configurationManager);
    }

    @Test
    void testSaveAndGet() throws IOException, ClassNotFoundException {
        Lecturer originalObject = new Lecturer();
        originalObject.setFirstName("Adebayo Atanda");
        originalObject.setLastName("Okutubo");
        originalObject.setEmail("adebayo@gmail.com");
        originalObject.setId("123455");

        Activity activity = new Activity();
        activity.setId(UUID.randomUUID().toString());
        activity.setType(ActivityType.ATS);

        originalObject.addActivity(activity);

        staffStorageRepository.save(originalObject.getId(), originalObject);
//        staffStorageRepository.save(originalObject.getId(), originalObject);

        Staff retrieved = staffStorageRepository.get(originalObject.getId());

        Assertions.assertEquals(originalObject, retrieved);
    }

    @Test
    void testFindAll() throws IOException, ClassNotFoundException {
        Lecturer originalObject = new Lecturer();
        originalObject.setFirstName("Adebayo Atanda");
        originalObject.setLastName("Okutubo");
        originalObject.setEmail("adebayo@gmail.com");
        originalObject.setId("123455");

        Lecturer originalObject2 = new Lecturer();
        originalObject2.setFirstName("Adebayo");
        originalObject2.setLastName("Atanda");
        originalObject2.setEmail("atanda@gmail.com");
        originalObject2.setId("123456");

        staffStorageRepository.save(originalObject.getId(), originalObject);
        staffStorageRepository.save(originalObject2.getId(), originalObject2);


        List<Staff> list = staffStorageRepository.findAll();
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testDelete() throws IOException, ClassNotFoundException {
        Lecturer originalObject = new Lecturer();
        originalObject.setFirstName("Adebayo Atanda");
        originalObject.setLastName("Okutubo");
        originalObject.setEmail("adebayo@gmail.com");
        originalObject.setId("123455");

        Lecturer originalObject2 = new Lecturer();
        originalObject2.setFirstName("Adebayo");
        originalObject2.setLastName("Atanda");
        originalObject2.setEmail("atanda@gmail.com");
        originalObject2.setId("123456");

        staffStorageRepository.save(originalObject.getId(), originalObject);
        staffStorageRepository.save(originalObject2.getId(), originalObject2);

        staffStorageRepository.delete(originalObject.getId());
        int noOfFiles = staffStorageRepository.findAll().size();

        Assertions.assertEquals(1, noOfFiles);
    }

    @Test
    void testDeleteAll() throws IOException, ClassNotFoundException {
        Lecturer originalObject = new Lecturer();
        originalObject.setFirstName("Adebayo Atanda");
        originalObject.setLastName("Okutubo");
        originalObject.setEmail("adebayo@gmail.com");
        originalObject.setId("123455");

        Lecturer originalObject2 = new Lecturer();
        originalObject2.setFirstName("Adebayo");
        originalObject2.setLastName("Atanda");
        originalObject2.setEmail("atanda@gmail.com");
        originalObject2.setId("123456");

        staffStorageRepository.save(originalObject.getId(), originalObject);
        staffStorageRepository.save(originalObject2.getId(), originalObject2);

        staffStorageRepository.deleteAll();
        int noOfFiles = staffStorageRepository.findAll().size();

        Assertions.assertEquals(0, noOfFiles);
    }

    @AfterAll
   static void clearAll() throws IOException, ClassNotFoundException {
        staffStorageRepository.deleteAll();
//        Assertions.assertThrows(IOException.class,() -> staffStorageRepository.deleteAll());
    }

}
