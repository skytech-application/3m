package fr.skytech.application.controller.error;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(value = "/errors/{errorId}", method = RequestMethod.GET)
	public String sendError(@PathVariable final int errorId) {
		return "error" + errorId;
	}

	@RequestMapping(value = "/errors/functional", method = RequestMethod.GET)
	@ExceptionHandler({ FunctionalException.class })
	public ResponseEntity<Object> sendFunctionalException(
			final RuntimeException exception, final WebRequest request,
			final Locale locale) {
		final FunctionalException functionalException = (FunctionalException) exception;
		final ErrorResource error = new ErrorResource("Functional error : ",
				this.applicationContext.getMessage(
						functionalException.getMessage(), new Object[] {},
						locale));

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return this.handleExceptionInternal(exception, error, headers,
				HttpStatus.UNPROCESSABLE_ENTITY, request);
	}

	@RequestMapping(value = "/errors/technical", method = RequestMethod.GET)
	@ExceptionHandler({ TechnicalException.class })
	public ResponseEntity<Object> sendTechnicalException(
			final RuntimeException exception, final WebRequest request,
			final Locale locale) {
		final TechnicalException technicalException = (TechnicalException) exception;
		final ErrorResource error = new ErrorResource("Technical error : ",
				this.applicationContext.getMessage(
						technicalException.getMessage(), new Object[] {},
						locale));

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return this.handleExceptionInternal(exception, error, headers,
				HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
}
