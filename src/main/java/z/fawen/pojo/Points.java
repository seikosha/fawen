package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Points {
    private int uid;
    private int sum_stars;
    private int sum_best;
    private int sum_solve;
    private int points;
}

