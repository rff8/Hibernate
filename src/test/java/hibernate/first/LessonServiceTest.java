package hibernate.first;

import hibernate.services.LessonService;
import hibernate.services.LessonServiceImpl;
import hibernate.services.PersonService;
import hibernate.services.PersonServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LessonServiceTest {
    PersonService personService;
    LessonService lessonService;
    Set<Pupil> pupils;
    Lector lector;
    Discipline discipline;
    Lesson lesson;

    @BeforeClass
    public void setup() {
        personService = new PersonServiceImpl();
        lessonService = new LessonServiceImpl(personService);
        createPupils();
        discipline = new Discipline("Math");
        lector = personService.createLector("Viacheslav","Voroncov",36);
        lesson = lessonService.createNewLesson(discipline, lector, pupils);
    }

    private void createPupils() {
        pupils = new HashSet<>();
        pupils.add(personService.createPupil("Ivan","Petrov",12, 6));
        pupils.add(personService.createPupil("Nikolay","Gogol",12, 6));
        pupils.add(personService.createPupil("Alexandr","Griboedov",12, 6));
        pupils.add(personService.createPupil("Ivan","Turgenev",12, 6));
        pupils.add(personService.createPupil("Arturo","Toscanini",12, 6));
    }

    @Test
    public void createNewLesson() {
        assertNotNull(lesson);
        assertEquals(lesson.getDiscipline().getName(), discipline.getName());
    }

    @Test
    public void checkPupil() {
        Pupil ivanPetrov = personService.createPupil("Ivan","Petrov",12, 6);
        assertTrue(lessonService.checkPupil(lesson, ivanPetrov));
    }

    @Test
    public void deletePupilSuccess() {
        Pupil ivanPetrov = personService.createPupil("Ivan","Petrov",12, 6);
        int initialSize = lesson.getPupils().size();
        Lesson newLessonDeleted =  lessonService.deletePupil(lesson, ivanPetrov);
        assertEquals(newLessonDeleted.getPupils().size(), initialSize-1);
    }

    @Test
    public void deletePupilFailed() {
        Pupil piotrChaikovsky = personService.createPupil("Piotr","Chaikovsky",12, 6);
        int initialSize = lesson.getPupils().size();
        Lesson newLessonDeleted =  lessonService.deletePupil(lesson, piotrChaikovsky);
        assertEquals(lesson.getPupils().size(), newLessonDeleted.getPupils().size());
    }

    @Test
    public void addPupil() {

    }
}
