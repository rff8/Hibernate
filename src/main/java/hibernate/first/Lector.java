package hibernate.first;

public class Lector extends Person {
    private Discipline[] disciplines;

    @Override
    public String toString() {
        return "Lector " + getFirstName() + getSecondName();
    }

    public Discipline[] getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Discipline[] disciplines) {
        this.disciplines = disciplines;
    }
}
