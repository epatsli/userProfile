package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import exception.UnknownIDException;
import project.service.UserService;
import project.to.FilterUserTO;
import project.to.UserTO;

@Controller
@ResponseBody
public class UserRestController {

	@Autowired
	private UserService service;

	private ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String some() {
		return "This is home page";
	}

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public List<UserTO> getAllUser() {
		return service.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserTO getUserById(@PathVariable("id") long id) {
		try {
			UserTO user = service.getUserById(id);
			return user;
		} catch (Exception ex) {
			new UnknownIDException();
		}
		return null;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUserById(@RequestBody UserTO user) {
		service.updateDateUser(user);
	}

	@RequestMapping(value = "/find", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserTO>> getUserByFilter(@RequestBody FilterUserTO userToFilter) {
		return ResponseEntity.ok().body(service.getUserByFilter(userToFilter));
	}

}
