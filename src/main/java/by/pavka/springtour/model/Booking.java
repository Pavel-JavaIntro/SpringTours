package by.pavka.springtour.model;

import javax.persistence.*;

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="tourist_id")
    private int touristId;

    @Column(name="tour_id")
    private int tourId;

    @Column(name="paid")
    private boolean paid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
