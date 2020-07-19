package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liked {
    private int id;
    private int liker_id;
    private int receiver_id;
    private int rid;
}

