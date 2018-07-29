package hibernate.first;

import hibernate.services.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pupil extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int grade;
    //private Set<Lesson> lessons;

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
/*
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
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
        if (obj instanceof Pupil) {
            Pupil anotherPupil = (Pupil)obj;
            boolean firstName = this.getFirstName().equals(anotherPupil.getFirstName());
            boolean secondName = this.getSecondName().equals(anotherPupil.getSecondName());
            boolean age = this.getAge() == anotherPupil.getAge();
            boolean grade = this.getGrade() == anotherPupil.getGrade();
            return firstName && secondName && age && grade;
        } else {
            return false;
        }
    }
}
