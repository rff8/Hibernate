package main.java;

public class Lesson {
    private Discipline discipline;
    private Lector lector;
    private Pupil[] pupils;

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Pupil[] getPupils() {
        return pupils;
    }

    public void setPupils(Pupil[] pupils) {
        this.pupils = pupils;
    }
}
