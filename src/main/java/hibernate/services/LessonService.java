package hibernate.services;

import hibernate.first.Discipline;
import hibernate.first.Lector;
import hibernate.first.Lesson;
import hibernate.first.Pupil;

import java.util.Set;

public interface LessonService {
    Lesson createNewLesson(Discipline discipline, Lector lector, Set<Pupil> pupils);
    Lesson addPupil(Lesson lesson, Pupil pupil);
    Lesson deletePupil(Lesson lesson, Pupil pupil);
    boolean checkPupil(Lesson lesson, Pupil pupil);
}
