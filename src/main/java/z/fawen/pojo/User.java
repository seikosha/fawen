package z.fawen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String email;
    private String location;
    private String status;
    private String description;
    private String password;
    private String create_time;
    private String last_login_time;
    private int stars;
    private int bests;
    private int solves;
    private int challenges;
    private String image_url;
}
