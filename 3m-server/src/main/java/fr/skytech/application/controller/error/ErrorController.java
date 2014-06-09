package fr.skytech.application.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;

@Controller
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@RequestMapping(value = "/errors/{errorId}", method = RequestMethod.GET)
	public String sendError(@PathVariable final int errorId) {
		return "error" + errorId;
	}

	@RequestMapping(value = "/errors/functionnal", method = RequestMethod.GET)
	@ExceptionHandler({ FunctionalException.class })
	public ResponseEntity<Object> sendFunctionnalException(
			final RuntimeException exception, final WebRequest request) {
		final FunctionalException functionalException = (FunctionalException) exception;
		final ErrorResource error = new ErrorResource("Functional error : ",
				functionalException.getMessage());

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return this.handleExceptionInternal(exception, error, headers,
				HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	@RequestMapping(value = "/errors/technical", method = RequestMethod.GET)
	@ExceptionHandler({ TechnicalException.class })
	public ResponseEntity<Object> sendTechnicalException(
			final RuntimeException exception, final WebRequest request) {
		final TechnicalException technicalException = (TechnicalException) exception;
		final ErrorResource error = new ErrorResource("Technical error : ",
				technicalException.getMessage());

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return this.handleExceptionInternal(exception, error, headers,
				HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

}
