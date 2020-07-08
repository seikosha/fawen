package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private int id;
    private int uid;
    private String title;
    private String content;
    private String category;
    private String location;
    private String create_time;
    private String update_time;

}

