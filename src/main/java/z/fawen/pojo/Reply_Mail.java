package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply_Mail {
    private int id;
    private int mid;
    private String content;
    private String reply_time;
    private int replyer_id;
}

