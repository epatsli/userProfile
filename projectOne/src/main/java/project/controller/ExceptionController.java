package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import exception.UnknownIDException;

@EnableWebMvc
@ControllerAdvice
public class ExceptionController {

	@ResponseBody
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public UnknownIDException businessExceptionHandler(Error ex) {

		return new UnknownIDException();
	}
}
