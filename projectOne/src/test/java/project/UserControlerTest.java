package project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.controller.UserRestController;
import project.service.UserService;
import project.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControlerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private UserService service;

	@InjectMocks
	private UserRestController userController;

	@Test
	public void shouldReturnUserById() throws Exception {

		// given
		final String expectedJSON = "{\"id\":1,\"email\":\"jan.nowak@gmail.com\",\"firstName\":\"Jan\",\"lastName\":\"Nowak\",\"password\":\"password\",\"lifeMotto\":\"Life is to short.\",\"playability\":null}";
		final int expectedHttpStatus = HttpStatus.OK.value();

		// when MvcResult
		MvcResult rawResponse = this.mockMvc.perform(get("/1").contentType(MediaType.APPLICATION_JSON)).andReturn();
		int responseHttpStatus = rawResponse.getResponse().getStatus();
		String responseJSON = rawResponse.getResponse().getContentAsString();

		// then
		Assert.assertEquals(expectedHttpStatus, responseHttpStatus);
		Assert.assertEquals(expectedJSON, responseJSON);

	}

	@Test
	public void shouldReturnAllUser() throws Exception {
		UserTO user = new UserTO(1, "Jan", "Nowak", "jan.nowak@gmail.com", "password", "Life is to short.", null);

		Mockito.when(service.getUserById(user.getId())).thenReturn(user);
		Mockito.doNothing().when(service).updateDateUser(user);

		mockMvc.perform(put("/{id}", user.getId()).contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isOk());
		Mockito.verify(service).getUserById(user.getId());
		Mockito.verify(service).updateDateUser(user);
		Mockito.verifyNoMoreInteractions(service);
	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
