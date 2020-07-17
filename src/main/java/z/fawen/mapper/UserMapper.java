package z.fawen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import z.fawen.pojo.Content;
import z.fawen.pojo.Mail;
import z.fawen.pojo.Reply;
import z.fawen.pojo.User;

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

    int addUser(User user);

    int addContent(Content content);

    int addReply(Reply reply);

    int addStar(int id);

    int addSolve(int id);

    int addBest(int id);

    int addChallenge(int id);

    int updateUser(User user);

    int deleteUser(int id);

}
