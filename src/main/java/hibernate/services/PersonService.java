package hibernate.services;

import hibernate.first.Discipline;
import hibernate.first.Lector;
import hibernate.first.Lesson;
import hibernate.first.Pupil;

import java.util.Set;

public interface PersonService {
    Pupil createPupil(String firstName, String secondName, int age, int grade);
    Lector createLector(String firstName, String secondName, int age);
}
