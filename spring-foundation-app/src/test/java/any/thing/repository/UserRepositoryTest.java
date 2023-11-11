package any.thing.repository;


import any.thing.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@Transactional
@ActiveProfiles("DEV")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataSource dataSource;

    @Before
    public void setUp() {
        User newUser = new User(null, "Lex", "es@rex");
        User actual = userRepository.save(newUser);
    }

    @Test
    public void testSaveUser() {
        User newUser = new User(null, "kill", "bill");

        User actual = userRepository.save(newUser);

        assert actual.getId() == 2 && actual.getName().equals("kill") && actual.getEmail().equals("bill");
    }

    @Test
    public void testGetUser() {
        User actual = userRepository.getById(3L);

        assert actual.equals(new User(3L, "Lex", "es@rex"));
    }

    @Test
    public void testGetUser_test() throws SQLException {
        // Custom Configuration subtask check
        Connection connection = dataSource.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

//        whenever @ActiveProfiles("PROD") there exist two options
        assertEquals(metaData.getURL(), "jdbc:h2:mem:prod_test"); // true when AnyService has an instance
//        assertEquals(metaData.getURL(), "jdbc:h2:mem:prod_test_condition"); // true when AnyService not in Context: AppConfig -> @Bean anyService() is commented

//        whenever @ActiveProfiles("!PROD") [NOT PROD] there exist two options
//        assertEquals(metaData.getURL(), "jdbc:h2:mem:qa_test"); // true when @ActiveProfiles("QA")
//        assertEquals(metaData.getURL(), "jdbc:h2:mem:dev_test"); // true when @ActiveProfiles("DEV")
    }
}