package no.jlwcrews.catapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgException(MethodArgumentNotValidException e){
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors().forEach( error -> {
            errors.put(error.getCode(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(CatNameStupidException.class)
    public ResponseEntity<String> handleCatNameStupidException(CatNameStupidException catNameStupidException){
        return ResponseEntity.badRequest().body("No, I really don't like your cat name at all");
    }
}
