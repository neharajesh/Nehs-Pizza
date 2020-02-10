package integrationTests;

import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import entities.UserEntity;
import repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserRepositoryIntegrationTest {

    private final String USER_PHNO = "23428553";
    private final String USER_EMAIL = "leehanseok3@gmail.com";

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenEmptyDBWhenFindByPhnoThenReturnEmptyOptional() {
        Optional<UserEntity> foundUser = userRepository.findByPhno(USER_PHNO);

        assertThat(foundUser.isPresent()).isEqualTo(false);
    }

    @Test
    public void givenUserInDBWhenFindByPhnoThenReturnOptionalWithUser() {
        UserEntity user = new UserEntity();
        user.setPhno(USER_PHNO);
        userRepository.save(user);

        Optional<UserEntity> foundUser = userRepository.findByPhno(USER_PHNO);

        assertThat(foundUser.isPresent()).isEqualTo(true);

        assertThat(foundUser
          .get()
          .getPhno()).isEqualTo(USER_PHNO);
    }
    
    @Test
    public void givenEmptyDBWhenFindByEmailThenReturnEmptyOptional() {
        Optional<UserEntity> foundUser = userRepository.findByEmail(USER_EMAIL);

        assertThat(foundUser.isPresent()).isEqualTo(false);
    }

    @Test
    public void givenUserInDBWhenFindByEmailThenReturnOptionalWithUser() {
        UserEntity user = new UserEntity();
        user.setEmail(USER_EMAIL);
        userRepository.save(user);

        Optional<UserEntity> foundUser = userRepository.findByEmail(USER_EMAIL);

        assertThat(foundUser.isPresent()).isEqualTo(true);

        assertThat(foundUser
          .get()
          .getEmail()).isEqualTo(USER_EMAIL);
    }

    /*@Test
    public void givenUserInDBWhenFindOneByStatusAsyncThenReturnCompletableFutureUser() throws ExecutionException, InterruptedException {
        User user = new User();
        user.setName(USER_NAME_ADAM);
        user.setStatus(ACTIVE_STATUS);
        userRepository.save(user);

        CompletableFuture<User> userByStatus = userRepository.findOneByStatus(ACTIVE_STATUS);

        assertThat(userByStatus
          .get()
          .getName()).isEqualTo(USER_NAME_ADAM);
    }*/

    @After
    public void cleanUp() {
        userRepository.deleteAll();
    }

}
