import com.example.assignment.backend.exceptions.InvalidObjectException;
import com.example.assignment.backend.models.StaffContractType;
import com.example.assignment.backend.models.dto.CreateStaff;
import com.example.assignment.backend.models.staff.Lecturer;
import com.example.assignment.backend.services.LecturerServiceImpl;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

public class LectureServiceImplTest {
    private final LecturerServiceImpl service ;

    public LectureServiceImplTest() throws ConfigurationException {
        service = LecturerServiceImpl.getInstance();
    }

    public static CreateStaff createLecturerRequest(){
        CreateStaff staff = new CreateStaff();
        staff.setFirstName("Micheal");
        staff.setLastName("Phelps");
        staff.setContractType(StaffContractType.PART_TIME);
        staff.setSubjectArea("Computer Science");
        staff.setId(UUID.randomUUID().toString());
        staff.setEmail("adebayo@uon.edu");
        staff.setManagerId(UUID.randomUUID().toString());


//        Activity activity = new Activity();
//        activity.setId(UUID.randomUUID().toString());
//        activity.setType(ActivityType.ATS);
//        staff

        return staff;
    }

    @Test
    public void testLecturerCreationWithValidInfo() throws InvalidObjectException, IOException, ClassNotFoundException {
        CreateStaff createStaff = createLecturerRequest();
        String id =createStaff.getId();
        service.create(createStaff);
        Lecturer retrieved = (Lecturer) service.get(id);
        Assertions.assertEquals(id, retrieved.getId());

    }

    @Test
    public void testLecturerCreationWithInvalidInfo(){

    }

    @Test
    public void testLecturerCreationWithEmptyInfo(){

    }
}
