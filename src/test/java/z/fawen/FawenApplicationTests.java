package z.fawen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import z.fawen.mapper.UserMapper;
import z.fawen.pojo.User;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class FawenApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

    }

}
