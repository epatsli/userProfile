package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserRestControler {

	// @Autowired
	// private UserService service;

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String some() {
		// UserTO someUser = service.addAvailabilityHour(new UserTO(2, "Olga",
		// "Ziemowit", "ola.kowalska@gmail.com",
		// "admin", "I want to die", Collections.EMPTY_LIST),
		// Collections.EMPTY_LIST);

		System.out.println("123");
		return "Some text";
	}
}
