package by.pavka.springtour.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tours")
public class Tour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name="type_id")
    private TourType tourType;

    @Column(name="description")
    private String description;

    @Column(name="capacity")
    private int capacity;

    @Column(name="booked")
    private int booked;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private Date endDate;

    @Column(name="price")
    private int price;

    @Column(name="tour_status")
    @Enumerated(EnumType.STRING)
    private TourStatus tourStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TourStatus getTourStatus() {
        return tourStatus;
    }

    public void setTourStatus(TourStatus tourStatus) {
        this.tourStatus = tourStatus;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", tourType=" + tourType +
                ", Description='" + description + '\'' +
                ", capacity=" + capacity +
                ", booked=" + booked +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price + "status= " + tourStatus +
                '}';
    }
}
