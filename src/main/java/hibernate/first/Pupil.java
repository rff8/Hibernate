package hibernate.first;

import javax.persistence.*;

@Entity
public class Pupil extends Person{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int grade;

    private Lesson[] lessons;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }
}
