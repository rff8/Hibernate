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
    public void createNewLesson(Discipline discipline, Lector lector, Set<Pupil> pupils) {
        Lesson lesson = new Lesson(discipline, lector);
        lesson.setPupils(pupils);
    }

    @Override
    public void addPupil(Pupil pupil) {

    }

    @Override
    public void deletePupil(Pupil pupil) {

    }
}
