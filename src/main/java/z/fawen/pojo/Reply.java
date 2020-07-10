package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private int id;
    private int cid;
    private int uid;
    private String content;
    private String create_time;
    private int stars;
    private int best;
    private boolean solve;
    private int challenges;
}
