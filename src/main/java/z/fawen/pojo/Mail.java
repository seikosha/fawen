package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mail {
    private int id;
    private int sender_id;
    private int receiver_id;
    private String title;
    private String content;
    private String send_time;
}
