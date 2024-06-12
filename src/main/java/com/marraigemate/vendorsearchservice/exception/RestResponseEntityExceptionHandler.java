package com.marraigemate.vendorsearchservice.exception;


import com.marraigemate.vendorsearchservice.DTO.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VendorNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageDTO employeeNotFoundHandler(VendorNotFoundException ex) {
        return new ErrorMessageDTO(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MongoDBAggregateQueryException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageDTO mongoDBAggregateQueryExceptionHandler(MongoDBAggregateQueryException ex) {
        System.out.println("MongoDBAggregateQueryException: " + ex.getMessage());
        return new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

}
