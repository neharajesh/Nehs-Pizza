package integrationTests;

import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import beans.UserDTO;

import static org.assertj.core.api.Assertions.assertThat;

import entities.User;
import repositories.UserRepository;
import service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserRepositoryIntegrationTest {
	/*private final String USER_FIRST_NAME = "neha";
	private final String USER_LAST_NAME = "rajesh";*/
	private final String USER_EMAIL = "leehanseok3@gmail.com";
    private final String USER_PHNO = "23428553";
    /*private final String USER_PASSWORD = "neharajesh";*/
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    @Test
    public void getAllUserDetails() {
    	List<UserDTO> users = userService.findAllUserDetails();
    	assertThat(users.size() > 1);
    	
    }

    @Test
    public void givenEmptyDBWhenFindByPhnoThenReturnEmptyOptional() {
        Optional<User> foundUser = userRepository.findByPhno(USER_PHNO);

        assertThat(foundUser.isPresent()).isEqualTo(false);
    }

    @Test
    public void givenUserInDBWhenFindByPhnoThenReturnOptionalWithUser() {
        User user = new User();
        user.setPhno(USER_PHNO);
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByPhno(USER_PHNO);

        assertThat(foundUser.isPresent()).isEqualTo(true);

        assertThat(foundUser
          .get()
          .getPhno()).isEqualTo(USER_PHNO);
    }
    
    @Test
    public void givenEmptyDBWhenFindByEmailThenReturnEmptyOptional() {
        Optional<User> foundUser = userRepository.findByEmail(USER_EMAIL);

        assertThat(foundUser.isPresent()).isEqualTo(false);
    }

    @Test
    public void givenUserInDBWhenFindByEmailThenReturnOptionalWithUser() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByEmail(USER_EMAIL);

        assertThat(foundUser.isPresent()).isEqualTo(true);

        assertThat(foundUser
          .get()
          .getEmail()).isEqualTo(USER_EMAIL);
    }

    @After
    public void cleanUp() {
        userRepository.deleteAll();
    }

}
