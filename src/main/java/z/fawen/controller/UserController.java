package z.fawen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import z.fawen.mapper.UserMapper;
import z.fawen.pojo.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();

//        for (User user : userList) {
//            System.out.println(user.getUsername());
//        }
        return userList;
    }
}
