package hibernate.services;

import hibernate.first.Discipline;
import hibernate.first.Lector;
import hibernate.first.Lesson;
import hibernate.first.Pupil;

import java.util.Set;

public class LessonServiceImpl implements LessonService{
    private PersonService personService;

    public LessonServiceImpl(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public Lesson createNewLesson(Discipline discipline, Lector lector, Set<Pupil> pupils) {
        Lesson lesson = new Lesson(discipline, lector);
        lesson.setPupils(pupils);
        return lesson;
    }

    @Override
    public Lesson addPupil(Lesson lesson, Pupil pupil) {
        if (checkPupil(lesson, pupil)) {
            return lesson;
        } else {
            Set<Pupil> newSet = lesson.getPupils();
            newSet.add(pupil);
            lesson.setPupils(newSet);
            return lesson;
        }
    }

    @Override
    public Lesson deletePupil(Lesson lesson, Pupil pupil) {
        if (checkPupil(lesson, pupil)) {
            Set<Pupil> newSet = lesson.getPupils();
            newSet.remove(pupil);
           lesson.setPupils(newSet);
            return lesson;
        } else {
            return lesson;
        }
    }

    @Override
    public boolean checkPupil(Lesson lesson, Pupil pupil) {
        if(lesson.getPupils().contains(pupil)) {
            return true;
        } else {
            return false;
        }
    }
}