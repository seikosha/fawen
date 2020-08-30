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

    @GetMapping("/queryRegister")
    public Integer queryRegister(String value){
        Integer legit = userMapper.queryRegister(value);
        return legit;
    }

    @GetMapping("/queryPoints")
    public List<Points> queryPoints(){
        List<Points> pointlist = userMapper.queryPoints();
        return pointlist;
    }

    @GetMapping("/queryReplyPage")
    public ReplyPage queryReplyPage(Integer limit,Integer uid){
        ReplyPage replyPage = userMapper.queryReplyPage(limit,uid);
        return replyPage;
    }

    @GetMapping("/queryMailPage")
    public MailPage queryMailPage(Integer limit,Integer uid){
        MailPage mailPage = userMapper.queryMailPage(limit,uid);
        return mailPage;
    }

    @GetMapping("/queryContentPageByKeyword")
    public ContentPage queryContentPageByKeyword(Integer limit, String keyword){
        ContentPage contentPage = userMapper.queryContentPageByKeyword(limit,keyword);
        return contentPage;
    }

    @GetMapping("/queryReplyPageByKeyword")
    public ReplyPage queryReplyPageByKeyword(Integer limit, String keyword){
        ReplyPage replyPage = userMapper.queryReplyPageByKeyword(limit,keyword);
        return replyPage;
    }

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/queryContentList")
    public List<Content> queryContentList(Integer start,Integer limit) {
        List<Content> contentList = userMapper.queryContentList(start,limit);
        return contentList;
    }

    @GetMapping("/queryContentPage")
    public ContentPage queryContentPage(Integer limit,Integer uid){
        ContentPage contentPage = userMapper.queryContentPage(limit,uid);
        return contentPage;
    }

    @GetMapping("/queryContentPageByCategory")
    public ContentPage queryContentPageByCategory(Integer limit, String category){
        ContentPage contentPage = userMapper.queryContentPageByCategory(limit,category);
        return contentPage;
    }

    @GetMapping("/queryContentPageWithoutUid")
    public ContentPage queryContentPageWithoutUid(Integer limit){
        ContentPage contentPage = userMapper.queryContentPageWithoutUid(limit);
        return contentPage;
    }

    @GetMapping("/queryReplyList")
    public List<Reply> queryReplyList(){
        List<Reply> replylist = userMapper.queryReplyList();
        return replylist;
    }

    @GetMapping("/queryReplyWithPage")
    public List<Reply> queryReplyWithPage(Integer start, Integer limit, Integer uid){
        List<Reply> replyList = userMapper.queryReplyWithPage(start,limit,uid);
        return replyList;
    }

    @GetMapping("/queryContentWithPage")
    public List<Content> queryContentWithPage(Integer start, Integer limit, Integer uid){
        List<Content> contentList = userMapper.queryContentWithPage(start,limit,uid);
        return contentList;
    }

    @GetMapping("/queryMailWithPage")
    public List<Mail> queryMailWithPage(Integer start, Integer limit, Integer receiver_id){
        List<Mail> mailList = userMapper.queryMailWithPage(start,limit,receiver_id);
        return mailList;
    }

    @GetMapping("/queryUserByUsername")
    public User queryUserByUsername(String username) {
        User userList = userMapper.queryUserByUsername(username);
        return userList;
    }

    @GetMapping("/queryContentByCid")
    public Content queryContentByCid(Integer cid) {
        Content content = userMapper.queryContentByCid(cid);
        return content;
    }

    @GetMapping("/queryContentByUid")
    public List<Content> queryContentByUid(Integer uid) {
        List<Content> contentList = userMapper.queryContentByUid(uid);
        return contentList;
    }

    @GetMapping("/queryUserById")
    public List<User> queryUserById(Integer id){
        List<User> userlist = userMapper.queryUserById(id);
        return userlist;
    }

    @GetMapping("/queryReplyByCid")
    public List<Reply> queryReplyByCid(Integer cid) {
        List<Reply> replyList = userMapper.queryReplyByCid(cid);
        return replyList;
    }

    @GetMapping("/queryReplyByUid")
    public List<Reply> queryReplyByUid(Integer uid) {
        List<Reply> replyList = userMapper.queryReplyByUid(uid);
        return replyList;
    }

    @GetMapping("/queryUsernameById")
    public String queryUsernameById(Integer id) {
        String username = userMapper.queryUsernameById(id);
        return username;
    }

    @GetMapping("/loginQuery")
    public List<User> loginQuery(String username, String password) {
        return userMapper.loginQuery(username, password);
    }

    @GetMapping("/queryReplyCount")
    public Integer queryReplyCount(Integer cid) {
        return userMapper.queryReplyCount(cid);
    }

    @GetMapping("/queryLastUpdateTime")
    public String queryLastUpdateTime(Integer cid) {
        return userMapper.queryLastUpdateTime(cid);
    }

    @GetMapping("/queryCategory")
    public Integer queryCategory(Integer uid, String category) {
        return userMapper.queryCategory(uid, category);
    }

    @GetMapping("/queryReplyData")
    public Integer queryReplyData(Integer uid) {
        return userMapper.queryReplyData(uid);
    }

    @GetMapping("/queryReplyStars")
    public Integer queryReplyStars(Integer uid) {
        return userMapper.queryReplyStars(uid);
    }

    @GetMapping("/queryReplyBest")
    public Integer queryReplyBest(Integer uid) {
        return userMapper.queryReplyBest(uid);
    }

    @GetMapping("/queryReplySolve")
    public Integer queryReplySolve(Integer uid) {
        return userMapper.queryReplySolve(uid);
    }

    @GetMapping("/queryMail")
    public List<Mail> queryMail(Integer receiver_id) {
        return userMapper.queryMail(receiver_id);
    }

    @GetMapping("/queryContentByTitleAndTime")
    public List<Content> queryContentByTitleAndTime(String title, String create_time) {
        return userMapper.queryContentByTitleAndTime(title, create_time);
    }

    @GetMapping("/queryMailByTitleAndTime")
    public List<Mail> queryMailByTitleAndTime(String title, String send_time) {
        return userMapper.queryMailByTitleAndTime(title, send_time);
    }

    @GetMapping("/queryCidByTitleAndTime")
    public Integer queryCidByTitleAndTime(String title, String time) {
        return userMapper.queryCidByTitleAndTime(title, time);
    }

    @GetMapping("/queryLiked")
    public int queryLiked(Integer liker_id, Integer rid) {
        return userMapper.queryLiked(liker_id, rid);
    }

    @GetMapping("/queryReplyMailByMid")
    public List<Reply_Mail> queryReplyMailByMid(Integer mid) {
        return userMapper.queryReplyMailByMid(mid);
    }

    @GetMapping("/queryContentByKeyword")
    public List<Content> queryContentByKeyword(Integer start, Integer limit,String keyword) {
        return userMapper.queryContentByKeyword(start,limit,keyword);
    }

    @GetMapping("/queryReplyByKeyword")
    public List<Reply> queryReplyByKeyword(Integer start, Integer limit,String keyword) {
        return userMapper.queryReplyByKeyword(start,limit,keyword);
    }

    @GetMapping("/queryUserByKeyword")
    public List<User> queryUserByKeyword(String keyword) {
        return userMapper.queryUserByKeyword(keyword);
    }

    @GetMapping("/queryContentByCountLocation")
    public List<Content> queryContentByCountLocation() {
        return userMapper.queryContentByCountLocation();
    }

    @GetMapping("/queryContentByLocation")
    public List<Content> queryContentByLocation(String location) {
        return userMapper.queryContentByLocation(location);
    }

    @GetMapping("/queryContentByCategory")
    public List<Content> queryContentByCategory(Integer start, Integer limit, String category) {
        return userMapper.queryContentByCategory(start, limit,category);
    }

    @GetMapping("/queryContentBySelection")
    public List<Content> queryContentBySelection() {
        return userMapper.queryContentBySelection();
    }

    //add
    @GetMapping("/addUser")
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @GetMapping("/addContent")
    public Integer addContent(Content content) {
        return userMapper.addContent(content);
    }

    @GetMapping("/addReply")
    public Integer addReply(Reply reply) {
        return userMapper.addReply(reply);
    }

    @GetMapping("/addLiked")
    public Integer addLike(Liked liked) {
        return userMapper.addLiked(liked);
    }

    @GetMapping("/addStar")
    public Integer addStar(int id) {
        return userMapper.addStar(id);
    }

    @GetMapping("/addSolve")
    public Integer addSolve(int id) {
        return userMapper.addSolve(id);
    }

    @GetMapping("/addBest")
    public Integer addBest(int id) {
        return userMapper.addBest(id);
    }

    @GetMapping("/addChallenge")
    public Integer addChallenge(int id) {
        return userMapper.addChallenge(id);
    }

    @GetMapping("/addMail")
    public Integer addMail(Mail mail) {
        return userMapper.addMail(mail);
    }

    @GetMapping("/addReplyMail")
    public Integer addReplyMail(Reply_Mail reply_mail) {
        return userMapper.addReplyMail(reply_mail);
    }

    @GetMapping("/addUpdateTime")
    public Integer addUpdateTime(int id, String update_time) {
        return userMapper.addUpdateTime(id, update_time);
    }

    //update
    @GetMapping("/updateLoginTime")
    public Integer updateLoginTime(String last_login_time,String username) {
        return userMapper.updateLoginTime(last_login_time,username);
    }

    @GetMapping("/updateUser")
    public Integer updateUser(String username,String email,String location,String status,String description,String password){
        return userMapper.updateUser(username,email,location,status,description,password);
    }


}