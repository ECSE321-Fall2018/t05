package ca.mcgill.ecse321.carpoolapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.carpoolapp.services.*;
import ca.mcgill.ecse321.carpoolapp.model.CarPoolManager;
import ca.mcgill.ecse321.carpoolapp.model.User;
import ca.mcgill.ecse321.carpoolapp.repository.CarpoolappRepository;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CarpoolappApplicationTests 
{

	@Test
	public void contextLoads() 
	{
		assertEquals(0, 0);
	}
	
	@Mock
	private CarPoolManager cm;
	private MethodServices service;
	
	@BeforeEach
	public void setUpEach() throws Exception 
	{
		cm = new CarPoolManager(123);
		service = new MethodServices(cm);
	}

	
	@Test
	void createUser() 
	{
		User user1 = service.createUser(101, "user1");
		try {
			User user2 = service.createUser(101, "user2");
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "User ID not unique!");
		}
		
		assertEquals(1, cm.getUsers().size());
		
		assertEquals(101, cm.getUser(0).getId());
		assertEquals("user1", user1.getName());
		assertEquals(0, user1.getUserRoles().size());
	}
	
	
}















