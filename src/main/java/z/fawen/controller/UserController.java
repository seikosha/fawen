package z.fawen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import z.fawen.mapper.UserMapper;
import z.fawen.pojo.Content;
import z.fawen.pojo.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/queryUserByUsername")
    public User queryUserByUsername(String username){
        User userList =  userMapper.queryUserByUsername(username);
        return userList;
    }

    @GetMapping("/addUser")
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @GetMapping("/loginQuery")
    public List<User> loginQuery(String username, String password){
        return userMapper.loginQuery(username, password);
    }

    @GetMapping("/addContent")
    public int addContent(Content content){return userMapper.addContent(content);}
}
