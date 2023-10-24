package ro.alex.springonetooneapi.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(UserInvalidAgeException.class)
    public ResponseEntity<String> userInvalidAgeException(UserInvalidAgeException userInvalidAgeException){
        return new ResponseEntity<>(objectToString(Map.of("message: ", userInvalidAgeException.getMessage())), HttpStatus.BAD_REQUEST);
    }


    private String objectToString(Object response){
        try{
            return objectMapper.writeValueAsString(response);
        }
        catch (JsonProcessingException e){
            log.error("Error processing response to string.");
            return "Internal error.";
        }
    }


}
