package hibernate.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PupilTest {
    SessionFactory factory;

    @BeforeClass
    public void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void savePupil() {
        Pupil pupil = new Pupil();
        pupil.setFirstName("Ivan");
        pupil.setSecondName("Smirnov");
        pupil.setAge(10);
        pupil.setGrade(5);

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(pupil);
            tx.commit();
        }
    }

    @Test(dependsOnMethods = "savePupil")
    public void readPupil() {
        try (Session session = factory.openSession()) {
            List<Pupil> list = session.createQuery("from Pupil", Pupil.class).list();

            assertEquals(list.size(), 1);
            for (Pupil p : list) {
                System.out.println(p);
            }
        }
    }
}