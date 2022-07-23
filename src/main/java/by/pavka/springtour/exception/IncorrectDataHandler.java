package by.pavka.springtour.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IncorrectDataHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleEx(NoSuchIDException ex) {
        IncorrectData id = new IncorrectData();
        id.setInfo(ex.getMessage());
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }
}
