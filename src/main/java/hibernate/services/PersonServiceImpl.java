package hibernate.services;

import hibernate.first.Discipline;
import hibernate.first.Lector;
import hibernate.first.Lesson;
import hibernate.first.Pupil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class PersonServiceImpl implements PersonService{
    @Override
    public Pupil createPupil(String firstName, String secondName, int age, int grade) {
        Pupil pupil = new Pupil(firstName, secondName, age, grade);
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(pupil);
            tx.commit();
        }
        return pupil;
    }

    @Override
    public Lector createLector(String firstName, String secondName, int age) {
        Lector lector = new Lector(firstName, secondName, age);
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(lector);
            tx.commit();
        }
        return lector;
    }
}
