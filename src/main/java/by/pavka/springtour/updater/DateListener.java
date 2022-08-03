package by.pavka.springtour.updater;

import by.pavka.springtour.model.Tour;
import by.pavka.springtour.model.TourStatus;
import by.pavka.springtour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class DateListener {

  @Autowired TourService tourService;

  @EventListener(ApplicationReadyEvent.class)
  public void runAfterStartup() {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    service.scheduleAtFixedRate(
        new Runnable() {
          @Override
          @Transactional
          public void run() {
            Date date = new Date();
            setExpired(date);
            setRunning(date);
          }
        },
        1,
        7200,
        TimeUnit.SECONDS);
  }

  private void setRunning(Date date) {
    List<Tour> tours = tourService.findByTourStatusAndStartDate(TourStatus.VALID, date);
    for (Tour tour : tours) {
      tourService.setRunning(tour.getId());
    }
  }

  private void setExpired(Date date) {
    List<Tour> tours = tourService.findByTourStatusAndEndDate(TourStatus.RUNNING, date);
    for (Tour tour : tours) {
      tourService.setExpired(tour.getId());
    }
  }
}
