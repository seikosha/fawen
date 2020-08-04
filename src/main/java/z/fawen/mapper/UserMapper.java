package z.fawen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import z.fawen.pojo.*;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    Integer queryRegister(String value);

    List<User> queryUserList();

    List<Content> queryContentList(Integer start,Integer limit);

    User queryUserByUsername(String username);

    List<Content> queryContentByUid(Integer uid);

    List<User> loginQuery(String username, String password);

    List<Reply> queryReplyByCid(Integer cid);

    List<Reply> queryReplyByUid(Integer uid);

    String queryUsernameById(Integer id);

    Integer queryReplyCount(Integer uid, Integer cid);

    String queryLastUpdateTime(Integer cid);

    Integer queryCategory(Integer uid,String category);

    Integer queryReplyData(Integer uid);

    Integer queryReplyStars(Integer uid);

    Integer queryReplyBest(Integer uid);

    Integer queryReplySolve(Integer uid);

    List<Mail> queryMail(int receiver_id);

    List<Content> queryContentByTitleAndTime(String title,String create_time);

    List<Mail> queryMailByTitleAndTime(String title,String send_time);

    Integer queryCidByTitleAndTime(String title,String time);

    List<Content> queryContentByKeyword(Integer start, Integer limit,String keyword);

    List<Reply> queryReplyByKeyword(Integer start, Integer limit,String keyword);

    List<User> queryUserByKeyword(String keyword);

    Content queryContentByCid(Integer cid);

    Integer queryLiked(Integer liker_id,Integer rid);

    List<Reply_Mail>queryReplyMailByMid(Integer mid);

    Integer addUser(User user);

    Integer addContent(Content content);

    Integer addReply(Reply reply);

    Integer addLiked(Liked liked);

    Integer addStar(Integer id);

    Integer addSolve(Integer id);

    Integer addBest(Integer id);

    Integer addChallenge(Integer id);

    Integer updateUser(User user);

    Integer addMail(Mail mail);

    Integer addReplyMail(Reply_Mail reply_mail);

    Integer addUpdateTime(Integer id, String update_time);

    List<Content> queryContentByCountLocation();

    List<Content> queryContentByLocation(String location);

    List<Content> queryContentByCategory(Integer start, Integer limit, String category);

    List<Content> queryContentBySelection();

    Integer updateLoginTime(String last_login_time,String username);

    List<Reply> queryReplyList();

    List<Points> queryPoints();

    ReplyPage queryReplyPage(Integer limit, Integer uid);

    ContentPage queryContentPage(Integer limit, Integer uid);

    ContentPage queryContentPageWithoutUid(Integer limit);

    MailPage queryMailPage(Integer limit, Integer uid);

    ContentPage queryContentPageByKeyword(Integer limit,String keyword);

    ContentPage queryContentPageByCategory(Integer limit, String category);

    ReplyPage queryReplyPageByKeyword(Integer limit, String keyword);

    List<Reply> queryReplyWithPage(Integer start, Integer limit, Integer uid);

    List<Content> queryContentWithPage(Integer start, Integer limit, Integer uid);

    List<Mail> queryMailWithPage(Integer start, Integer limit, Integer receiver_id);

    List<User> queryUserById(Integer id);

    Integer updateUser(String username,String email,String location,String status,String description,String password);



}
