import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class UtilsTest {

    @BeforeAll
    public static void init(){

    }

    @Test
    public void readFile() throws IOException {

        File tempFile = File.createTempFile("test", ".csv");
        tempFile.deleteOnExit();

        //Write test data to the temporary csv
    }

}
