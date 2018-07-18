package hibernate.first;

import org.testng.annotations.Test;

public class CreatingObjectsTest {
    @Test
    public void createPupil() {
        Pupil ivanSmirnov = new Pupil();
        ivanSmirnov.setFirstName("Ivan");
        ivanSmirnov.setSecondName("Smirnov");
        ivanSmirnov.setAge(10);
        ivanSmirnov.setGrade(5);
    }

    @Test
    public void createLector() {
        Lector viacheslav = new Lector();
        viacheslav.setFirstName("Viacheslav");
        viacheslav.setSecondName("Korobkin");
        viacheslav.setAge(40);
    }
}
