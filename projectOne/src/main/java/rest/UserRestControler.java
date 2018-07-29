package rest;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.service.UserService;
import project.to.UserTO;

@Controller
@ResponseBody
public class UserRestControler {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String some() {
		// UserTO someUser = service.addAvailabilityHour(new UserTO(2, "Olga",
		// "Ziemowit", "ola.kowalska@gmail.com",
		// "admin", "I want to die", Collections.EMPTY_LIST),
		// Collections.EMPTY_LIST);

		System.out.println("123");
		return "Some text";
	}

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public List<UserTO> getAllUser() {
		return service.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserTO getUserById(@PathVariable("id") int id) {
		return service.getUserById(id);
	}

	// @PutMapping(value = "/{id}")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUserById(@RequestBody UserTO user) {
		service.updateDateUser(user);
	}
	/*
	 * @RequestMapping(value = "/user", method = RequestMethod.GET) public
	 * UserTO getUser() { return service.updateDateUser( new UserTO(1, "Jan",
	 * "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));
	 * }
	 */
}
