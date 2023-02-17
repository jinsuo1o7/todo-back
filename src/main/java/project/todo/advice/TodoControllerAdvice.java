package project.todo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeExceptionHandler(RuntimeException e) {
        return new ResponseEntity<>("some error !", HttpStatus.BAD_GATEWAY);
    }
}
