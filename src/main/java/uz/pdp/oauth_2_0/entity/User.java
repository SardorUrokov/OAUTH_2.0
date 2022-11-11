package uz.pdp.oauth_2_0.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // Entity for Google and GitHub accounts
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String given_name;
    private String picture; // img url
    private String type;    // user, admin
    private String email;   // @gmail account
    private String login;   // login name
    private String bio;     // bio
    private String avatar_url; //gitHub profile picture url
    private String url;     // user link
    private String repos_url;     // gitHub repository link
    private String created_at;
    private String updated_at;
    private String followers; //gitHub followers
    private String following; //gitHub followings
    private String location; //gitHub location

}
