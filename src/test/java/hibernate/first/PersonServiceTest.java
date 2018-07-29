package hibernate.first;

import hibernate.services.PersonService;
import hibernate.services.PersonServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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
}
