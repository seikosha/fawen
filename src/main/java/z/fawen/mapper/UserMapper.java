package z.fawen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import z.fawen.pojo.*;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    List<Content> queryContentList();

    User queryUserByUsername(String username);

    List<Content> queryContentByUid(int uid);

    List<User> loginQuery(String username, String password);

    List<Reply> queryReplyByCid(int cid);

    List<Reply> queryReplyByUid(Integer uid);

    String queryUsernameById(Integer id);

    int queryReplyCount(int uid, int cid);

    String queryLastUpdateTime(int cid);

    Integer queryCategory(Integer uid,String category);

    Integer queryReplyData(int uid);

    Integer queryReplyStars(int uid);

    Integer queryReplyBest(int uid);

    Integer queryReplySolve(int uid);

    List<Mail> queryMail(int receiver_id);

    List<Content> queryContentByTitleAndTime(String title,String create_time);

    List<Mail> queryMailByTitleAndTime(String title,String send_time);

    int queryCidByTitleAndTime(String title,String time);

    List<Content> queryContentByKeyword(String keyword);

    List<Reply> queryReplyByKeyword(String keyword);

    List<User> queryUserByKeyword(String keyword);

    Content queryContentByCid(int cid);

    Integer queryLiked(int liker_id,int rid);

    List<Reply_Mail>queryReplyMailByMid(int mid);

    int addUser(User user);

    int addContent(Content content);

    int addReply(Reply reply);

    int addLiked(Liked liked);

    int addStar(int id);

    int addSolve(int id);

    int addBest(int id);

    int addChallenge(int id);

    int updateUser(User user);

    int deleteUser(int id);

    int addMail(Mail mail);

    int addReplyMail(Reply_Mail reply_mail);

    int addUpdateTime(int id, String update_time);

    List<Content> queryContentByCountLocation();

    List<Content> queryContentByLocation(String location);

    List<Content> queryContentByCategory(String category);

    List<Content> queryContentBySelection();

    int updateLoginTime(String last_login_time,String username);

}
