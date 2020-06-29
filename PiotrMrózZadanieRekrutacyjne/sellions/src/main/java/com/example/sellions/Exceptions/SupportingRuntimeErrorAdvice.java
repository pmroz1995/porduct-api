package com.example.sellions.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SupportingRuntimeErrorAdvice {


    @ResponseBody
    @ExceptionHandler(SupportingRuntimeError.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RuntimeErrorHandler(SupportingRuntimeError ex){
        return ex.getMessage();
    }

}
