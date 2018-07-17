package main.java;

public class Discipline {
    private String name;
    private Lector[] lectors;

    public Lector[] getLectors() {
        return lectors;
    }

    public void setLectors(Lector[] lectors) {
        this.lectors = lectors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
