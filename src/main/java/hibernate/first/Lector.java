package hibernate.first;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lector extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Discipline[] disciplines;

    @Override
    public String toString() {
        return "Lector " + getFirstName() + " " + getSecondName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discipline[] getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Discipline[] disciplines) {
        this.disciplines = disciplines;
    }
}
