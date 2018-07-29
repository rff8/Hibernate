package hibernate.first;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Lector extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private Set<Discipline> disciplines;

    public Lector(String firstName, String secondName, int age) {
        super(firstName, secondName, age);
    }

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
/*
    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        String name = this.getFirstName() + this.getSecondName();
        char[] charSet = name.toCharArray();
        for (int i = 0; i < charSet.length; i++) {
            int h = (int) charSet[i];
            hash =+ h;
        }
        return hash + this.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Lector) {
            Lector anotherLector = (Lector)obj;
            boolean firstName = this.getFirstName().equals(anotherLector.getFirstName());
            boolean secondName = this.getSecondName().equals(anotherLector.getSecondName());
            boolean age = this.getAge() == anotherLector.getAge();
            return firstName && secondName && age;
        } else {
            return false;
        }
    }
}
