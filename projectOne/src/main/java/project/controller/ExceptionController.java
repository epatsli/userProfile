package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import project.exception.ClientError;
import project.exception.UserNotFoundException;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {

	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ClientError businessExceptionHandler(UserNotFoundException ex) {

		return new ClientError(new Date(), ex.getMessage());
	}
}
