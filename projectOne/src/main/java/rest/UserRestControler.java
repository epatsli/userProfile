package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.service.UserService;
import project.to.FilterUserTO;
import project.to.UserTO;

@Controller
@ResponseBody
public class UserRestControler {

	@Autowired
	private UserService service;

	private ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/some", method = RequestMethod.GET)
	public String some() {
		System.out.println("123");
		return "Some text";
	}

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public List<UserTO> getAllUser() {
		return service.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserTO getUserById(@PathVariable("id") int id) {

		UserTO user = service.getUserById(id);
		return user;

	}

	/*
	 * @RequestMapping(value = "/{id}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<String>
	 * getUserByIds(@PathVariable("id") int id) {
	 * 
	 * UserTO user = service.getUserById(id); try { return new
	 * ResponseEntity<>(objectMapper.writeValueAsString(user), HttpStatus.OK); }
	 * catch (JsonProcessingException e) { return new ResponseEntity<>(
	 * "Error when preparing response", HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */
	// @PutMapping(value = "/{id}")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUserById(@RequestBody UserTO user) {
		service.updateDateUser(user);
	}

	// @RequestMapping(value = "/byName/{firstName}/{lastName}", method =
	// RequestMethod.GET)

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<UserTO> getUserByFilter(@RequestBody FilterUserTO userToFilter) {
		List<UserTO> user = service.getUserByFilter(userToFilter);
		return user;
	}
	/*
	 * @RequestMapping(value = "/user", method = RequestMethod.GET) public
	 * UserTO getUser() { return service.updateDateUser( new UserTO(1, "Jan",
	 * "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null));
	 * }
	 */
}
