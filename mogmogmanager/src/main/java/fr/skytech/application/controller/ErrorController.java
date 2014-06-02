package fr.skytech.application.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.skytech.application.exception.ErrorResource;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;


@Controller
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler{

	@RequestMapping(value="/errors/404", method=RequestMethod.GET)
    public String  sendError404() {
        return "error404";
    }
	
	@RequestMapping(value="/errors/technical", method=RequestMethod.GET)
	@ExceptionHandler({ TechnicalException.class })
	public  ResponseEntity<Object> sendTechnicalException(RuntimeException exception, WebRequest request) {
		TechnicalException technicalException = (TechnicalException) exception;
        ErrorResource error = new ErrorResource("Technical error : ", technicalException.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(exception, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
	
	@RequestMapping(value="/errors/functionnal", method=RequestMethod.GET)
	@ExceptionHandler({ FunctionalException.class })
    public  ResponseEntity<Object> sendFunctionnalException(RuntimeException exception, WebRequest request) {
		FunctionalException functionalException = (FunctionalException) exception;
        ErrorResource error = new ErrorResource("Functional error : ", functionalException.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(exception, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
	
	
}
