package hibernate.services;

import hibernate.first.Discipline;
import hibernate.first.Lector;
import hibernate.first.Pupil;

import java.util.Set;

public interface LessonService {
    void createNewLesson(Discipline discipline, Lector lector, Set<Pupil> pupils);
    void addPupil(Pupil pupil);
    void deletePupil(Pupil pupil);
}
