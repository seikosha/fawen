package z.fawen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import z.fawen.mapper.UserMapper;
import z.fawen.pojo.Content;
import z.fawen.pojo.Reply;
import z.fawen.pojo.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //query
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/queryUserByUsername")
    public User queryUserByUsername(String username){
        User userList = userMapper.queryUserByUsername(username);
        return userList;
    }

    @GetMapping("/queryContentByUid")
    public List<Content> queryContentByUid(int uid){
        List<Content> contentList = userMapper.queryContentByUid(uid);
        return contentList;
    }

    @GetMapping("/queryReplyByCid")
    public List<Reply> queryReplyByCid(int cid){
        List<Reply> replyList = userMapper.queryReplyByCid(cid);
        return replyList;
    }

    @GetMapping("/queryUsernameById")
    public String queryUsernameById(Integer id){
        String username = userMapper.queryUsernameById(id);
        return username;
    }


    @GetMapping("/loginQuery")
    public List<User> loginQuery(String username, String password){
        return userMapper.loginQuery(username, password);
    }



    //add
    @GetMapping("/addUser")
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @GetMapping("/addContent")
    public int addContent(Content content){return userMapper.addContent(content);}

    @GetMapping("/addReply")
    public int addReply(Reply reply){return userMapper.addReply(reply);}

    @GetMapping("/addStar")
    public int addStar(int id){return userMapper.addStar(id);}

    @GetMapping("/addSolve")
    public int addSolve(int id){return userMapper.addSolve(id);}

    @GetMapping("/addBest")
    public int addBest(int id){return userMapper.addBest(id);}


}
