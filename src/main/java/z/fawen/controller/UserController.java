package z.fawen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import z.fawen.mapper.UserMapper;
import z.fawen.pojo.*;

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

    @GetMapping("/queryContentList")
    public List<Content> queryContentList(){
        List<Content> contentList = userMapper.queryContentList();
        return contentList;
    }

    @GetMapping("/queryUserByUsername")
    public User queryUserByUsername(String username){
        User userList = userMapper.queryUserByUsername(username);
        return userList;
    }

    @GetMapping("/queryContentByCid")
    public Content queryContentByCid(int cid){
        Content content = userMapper.queryContentByCid(cid);
        return content;
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

    @GetMapping("/queryReplyByUid")
    public List<Reply> queryReplyByUid(Integer uid){
        List<Reply> replyList = userMapper.queryReplyByUid(uid);
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

    @GetMapping("/queryReplyCount")
    public int queryReplyCount(int uid, int cid){ return userMapper.queryReplyCount(uid,cid);}

    @GetMapping("/queryLastUpdateTime")
    public String queryLastUpdateTime(int cid){return userMapper.queryLastUpdateTime(cid);}

    @GetMapping("/queryCategory")
    public Integer queryCategory(Integer uid,String category){return userMapper.queryCategory(uid,category);}

    @GetMapping("/queryReplyData")
    public Integer queryReplyData(int uid){return userMapper.queryReplyData(uid);}

    @GetMapping("/queryReplyStars")
    public Integer queryReplyStars(int uid){return userMapper.queryReplyStars(uid);}

    @GetMapping("/queryReplyBest")
    public Integer queryReplyBest(int uid){return userMapper.queryReplyBest(uid);}

    @GetMapping("/queryReplySolve")
    public Integer queryReplySolve(int uid){return userMapper.queryReplySolve(uid);}

    @GetMapping("/queryMail")
    public List<Mail> queryMail(int receiver_id){return userMapper.queryMail(receiver_id);}

    @GetMapping("/queryContentByTitleAndTime")
    public List<Content> queryContentByTitleAndTime(String title, String create_time){return userMapper.queryContentByTitleAndTime(title,create_time);}

    @GetMapping("/queryMailByTitleAndTime")
    public List<Mail> queryMailByTitleAndTime(String title,String send_time){return userMapper.queryMailByTitleAndTime(title,send_time);}

    @GetMapping("/queryCidByTitleAndTime")
    public int queryCidByTitleAndTime(String title, String time){return userMapper.queryCidByTitleAndTime(title,time);}

    @GetMapping("/queryLiked")
    public int queryLiked(int liker_id, int rid){return userMapper.queryLiked(liker_id,rid);}

    @GetMapping("/queryReplyMailByMid")
    public List<Reply_Mail> queryReplyMailByMid(int mid){return userMapper.queryReplyMailByMid(mid);}

    @GetMapping("/queryContentByKeyword")
    public List<Content> queryContentByKeyword(String keyword){return userMapper.queryContentByKeyword(keyword);}

    @GetMapping("/queryReplyByKeyword")
    public List<Reply> queryReplyByKeyword(String keyword){return userMapper.queryReplyByKeyword(keyword);}

    @GetMapping("/queryUserByKeyword")
    public List<User> queryUserByKeyword(String keyword){return userMapper.queryUserByKeyword(keyword);}

    //add
    @GetMapping("/addUser")
    public Integer addUser(User user){
        return userMapper.addUser(user);
    }

    @GetMapping("/addContent")
    public int addContent(Content content){return userMapper.addContent(content);}

    @GetMapping("/addReply")
    public int addReply(Reply reply){return userMapper.addReply(reply);}

    @GetMapping("/addLiked")
    public int addLike(Liked liked){ return userMapper.addLiked(liked);}

    @GetMapping("/addStar")
    public int addStar(int id){return userMapper.addStar(id);}

    @GetMapping("/addSolve")
    public int addSolve(int id){return userMapper.addSolve(id);}

    @GetMapping("/addBest")
    public int addBest(int id){return userMapper.addBest(id);}

    @GetMapping("/addChallenge")
    public int addChallenge(int id){return userMapper.addChallenge(id);}

    @GetMapping("/addMail")
    public int addMail(Mail mail){return userMapper.addMail(mail);}

    @GetMapping("/addReplyMail")
    public int addReplyMail(Reply_Mail reply_mail){return userMapper.addReplyMail(reply_mail);}

    @GetMapping("/addUpdateTime")
    public int addUpdateTime(int id, String update_time){return userMapper.addUpdateTime(id, update_time);}
}
