package com.jt.sms.exception;

import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.NoSuchElementException;
import java.util.StringJoiner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {

    // @ExceptionHandler(StudentNotFoundException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // public Map<String, String> handleNoSuchElementException(StudentNotFoundException nsee){
    //     // System.out.println("Exception Handled!");
    //     var map = new HashMap<String, String>();
    //     map.put("title", "Not Found!!");
    //     map.put("detail", nsee.getMessage());
    //     map.put("timestamp", LocalDateTime.now().toString());
    //     return map;
    // }
    @ExceptionHandler(StudentNotFoundException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST) //Not required when ProblemDetail class is used
    public ProblemDetail handleNoSuchElementException(StudentNotFoundException nsee) {
        // ProblemDetail problemDetail = ProblemDetail.forStatus(400);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, nsee.getMessage()); // industry standard
        problemDetail.setTitle("Student Not Found");
        // problemDetail.setDetail(nsee.getMessage());
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handleRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return ProblemDetail.forStatusAndDetail(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handler(MethodArgumentNotValidException e){
        var details = new StringJoiner(",");
        e.getAllErrors().forEach(error -> {
            var errorMessage = error.getDefaultMessage();
            var fieldName = ((FieldError) error).getField();
            details.add(fieldName + " : "+ errorMessage);
        });
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, details.toString());
        problemDetail.setTitle("Invalid Data");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;
    }
}
