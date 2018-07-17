package main.java;

public class Pupil extends Person{
    private int grade;
    private Lesson[] lessons;

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
