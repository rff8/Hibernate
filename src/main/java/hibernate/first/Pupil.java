package hibernate.first;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pupil extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int grade;
    private Set<Lesson> lessons;

    public Pupil(String firstName, String secondName, int age, int grade) {
        super(firstName, secondName, age);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Pupil " + getFirstName() + " " + getSecondName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {return grade;}

    public void setGrade(int grade) {this.grade = grade;}

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
