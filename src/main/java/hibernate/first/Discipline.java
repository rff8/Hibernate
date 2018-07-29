package hibernate.first;

import javax.persistence.*;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    public Discipline(String name) {
        this.name = name;
    }

    private Lector[] lectors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
