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

public class LectorTest {
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
    public void saveLector() {
        Lector lector = new Lector();
        lector.setFirstName("Viacheslav");
        lector.setSecondName("Kolobin");
        lector.setAge(45);

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(lector);
            tx.commit();
        }
    }

    @Test(dependsOnMethods = "saveLector")
    public void readLector() {
        try (Session session = factory.openSession()) {
            List<Lector> list = session.createQuery("from Lector", Lector.class).list();

            assertEquals(list.size(), 1);
            for (Lector l : list) {
                System.out.println(l);
            }
        }
    }
}
