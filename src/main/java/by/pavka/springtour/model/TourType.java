package by.pavka.springtour.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="tour_types")
public class TourType implements Serializable {
    public TourType() {
    }

    public TourType(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="type")
    private String description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourType tourType = (TourType) o;
        return description.equals(tourType.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
