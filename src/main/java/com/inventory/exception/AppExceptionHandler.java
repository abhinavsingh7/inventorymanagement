package com.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.inventory.model.Response;

@EnableWebMvc // enables this controller advice
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	public AppExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Response> handleException(Exception exception) {
		Response error = new Response();
		error.setErrorDetails(exception.getMessage());
		error.setResponseCode( HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Response>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}