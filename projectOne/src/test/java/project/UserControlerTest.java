package project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import project.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControlerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private UserService service;

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

}
