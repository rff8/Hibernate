package hibernate.first;

import hibernate.services.PersonService;
import hibernate.services.PersonServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

public class PersonServiceTest {
    PersonService personService;

    @BeforeClass
    public void setup() {
        personService = new PersonServiceImpl();
    }

    @Test
    public void createPupil() {
        Pupil ivanPetrov = personService.createPupil("Ivan","Petrov",12, 6);
        assertNotNull(ivanPetrov);
        assertEquals(ivanPetrov.getFirstName(), "Ivan");
        assertEquals(ivanPetrov.getSecondName(), "Petrov");
        assertEquals(ivanPetrov.getAge(), 12);
        assertEquals(ivanPetrov.getGrade(), 6);
    }

    @Test
    public void createLector() {
        Lector lectorViacheslav = personService.createLector("Viacheslav","Voroncov",36);
        assertNotNull(lectorViacheslav);
        assertEquals(lectorViacheslav.getFirstName(), "Viacheslav");
        assertEquals(lectorViacheslav.getSecondName(), "Voroncov");
        assertEquals(lectorViacheslav.getAge(), 36);
    }

    @Test
    public void testPupilEquals() {
        Person pupil1 = personService.createPupil("Ivan","Petrov",12, 6);
        Person pupil2 = personService.createPupil("Ivan","Petrov",12, 6);
        Person pupil3 = personService.createPupil("Ivan","Petrov",11, 6);
        assertEquals(pupil1, pupil2);
        assertNotEquals(pupil1, pupil3);
    }

    @Test
    public void testLectorEquals() {
        Lector lector1 = personService.createLector("Viacheslav","Voroncov",36);
        Lector lector2 = personService.createLector("Viacheslav","Voroncov",36);
        Lector lector3 = personService.createLector("Viacheslav","Voroncovs",36);
        assertEquals(lector1, lector2);
        assertNotEquals(lector1, lector3);
    }
}
