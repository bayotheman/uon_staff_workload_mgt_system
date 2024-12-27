import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.services.FileManager;
import com.example.assignment.backend.services.LecturerServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {

    private static final String TEST_DIR = "/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment/target/testDir";
    private static final String TEST_FILE = "testFile.dat";
    private static final String TEST_FILE_PATH = TEST_DIR + "/" + TEST_FILE;

    @BeforeAll
    static void setup() {
        File dir = new File(TEST_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    @AfterAll
    static void cleanup() {
        File dir = new File(TEST_DIR);
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            file.delete();
        }
        dir.delete();
    }

    @Test
    void testSaveAndGet() throws IOException, ClassNotFoundException {
        Lecturer testObject = new Lecturer();
        testObject.setFirstName("Adebayo Atanda");
        testObject.setLastName("Okutubo");
        testObject.setEmail("adebayo@gmail.com");
        testObject.setId("123455");

        // Save the object
        FileManager.save(TEST_FILE_PATH, testObject);

        // Retrieve the object
        Serializable retrievedObject = FileManager.get(TEST_FILE_PATH);

        // Assert that the retrieved object matches the saved object
        assertEquals(testObject.toString(), retrievedObject.toString(), "The retrieved object should match the saved object.");
    }

    @Test
    void TestFindAll() throws IOException {
        for(int i = 0; i < 4; i++){
            Lecturer originalObject = new Lecturer();
            originalObject.setFirstName("Adebayo Atanda");
            originalObject.setLastName("Okutubo");
            originalObject.setEmail("adebayo@gmail.com");
            originalObject.setId("123455");
            String filename  = TEST_DIR + "/test%s.dat".formatted(i);
            FileManager.save(filename, originalObject);
        }

        List<Serializable> retrieved = FileManager.getAll(TEST_DIR, ".dat");
        assertEquals(4, retrieved.size());
    }
    @Test
    void testUpdate() throws IOException, ClassNotFoundException {
        Lecturer originalObject = new Lecturer();
        originalObject.setFirstName("Adebayo Atanda");
        originalObject.setLastName("Okutubo");
        originalObject.setEmail("adebayo@gmail.com");
        originalObject.setId("123455");

        // Save the original object
        FileManager.save(TEST_FILE_PATH, originalObject);

        originalObject.setEmail("atanda@gmail.com");

        // Update the file with the new object
        FileManager.update(TEST_FILE_PATH, originalObject);

        // Retrieve the updated object
        Serializable retrievedObject = FileManager.get(TEST_FILE_PATH);

        // Assert that the retrieved object matches the updated object
        assertEquals(originalObject, retrievedObject, "The retrieved object should match the updated object.");
    }

    @Test
    void testDelete() throws IOException {
        Lecturer testObject = new Lecturer();
        testObject.setFirstName("Adebayo Atanda");
        testObject.setLastName("Okutubo");
        testObject.setEmail("adebayo@gmail.com");
        testObject.setId("123455");
        // Save the object
        FileManager.save(TEST_FILE_PATH, testObject);

        // Delete the file
        FileManager.delete(TEST_FILE_PATH);

        // Assert that the file no longer exists
        File file = new File(TEST_FILE_PATH);
        assertFalse(file.exists(), "The file should be deleted.");
    }

    @Test
    void testGetNonExistentFile() {
        assertThrows(IOException.class, () -> FileManager.get(TEST_DIR + "/" +"nonExistentFile.dat"),
                "Attempting to get a non-existent file should throw an IOException.");
    }
}
