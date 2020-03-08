package integrationTests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import controller.LoginController;

public class ControllerTest {
	
	
	@Test
	public void loginControllerTest() {
		LoginController loginController = new LoginController();
		String result = loginController.index();
		assertEquals(result,"index");
	}
}
