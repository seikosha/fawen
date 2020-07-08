package z.fawen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import z.fawen.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    List<User> loginQuery(String username, String password);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
