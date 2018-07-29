package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import exception.UnknownIDException;

@Controller
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = UnknownIDException.class)
	public static ModelAndView prepareExceptionModelAndView(String exceptionMessage) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exceptionMessage", exceptionMessage);
		mav.setViewName("error");

		return mav;
	}
}
