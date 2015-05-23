package javacommunity.airlinetravel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class GlobalExceptionHandlingControler {

    @ExceptionHandler(Exception.class)
    public String unknowErrorException(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception exception) {
        exception.printStackTrace();
        return "500";
    }
 
}
