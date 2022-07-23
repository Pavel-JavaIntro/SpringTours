package by.pavka.springtour.service;

import by.pavka.springtour.exception.NoSuchIDException;
import by.pavka.springtour.mapper.TourMapper;
import by.pavka.springtour.model.Tour;
import by.pavka.springtour.repository.TourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Service
public class TourDaoImpl implements TourDao {
    private JdbcTemplate jdbcTemplate;
    private TourMapper tourMapper;

    @Autowired
    public TourDaoImpl(JdbcTemplate jdbcTemplate, TourMapper tourMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.tourMapper = tourMapper;
    }

    @Override
    public Tour getTourById(int id) {
        try {
            Tour tour = jdbcTemplate.queryForObject("SELECT * FROM tours WHERE id=?", tourMapper, id);
            return tour;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new NoSuchIDException("Tour with id = " + id + " is not found in the DB");
        }
    }

    @Override
    public List<Tour> getAllTours() {
        return jdbcTemplate.query("SELECT * FROM tours", tourMapper);
    }

    @Override
    public int addTour(Tour tour) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql =
                "INSERT INTO tours (status_id, description, capacity, start_date, end_date, price, booked, type_id) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, tour.getStatusId());
                    ps.setString(2, tour.getDescription());
                    ps.setInt(3, tour.getCapacity());
                    ps.setDate(4, new java.sql.Date(tour.getStartDate().getTime()));
                    ps.setDate(5, new java.sql.Date(tour.getEndDate().getTime()));
                    ps.setInt(6, tour.getPrice());
                    ps.setInt(7, tour.getBooked());
                    ps.setInt(8, tour.getTypeId());
                    return ps;
                },
                keyHolder);
        return (int)keyHolder.getKeys().get("id");
    }

    @Override
    public int updateTour(Tour tour) {
        return jdbcTemplate.update(
                "UPDATE tours SET status_id=?, description=?, capacity=?, start_date=?, end_date=?"
                        + ", price=?, booked=?, type_id=?"
                        + "WHERE id=?",
                tour.getStatusId(),
                tour.getDescription(),
                tour.getCapacity(),
                tour.getStartDate(),
                tour.getEndDate(),
                tour.getPrice(),
                tour.getBooked(),
                tour.getTypeId(),
                tour.getId());
    }

    @Override
    public int deleteTour(int id) {
        return jdbcTemplate.update("DELETE FROM tours WHERE id=?", id);
    }
}
