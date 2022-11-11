package uz.pdp.oauth_2_0.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import uz.pdp.oauth_2_0.repository.UserRepository;
import org.springframework.ui.Model;
import uz.pdp.oauth_2_0.entity.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal) {
        User RegisterUser = new User();
        RegisterUser.setBio(principal.getAttribute("bio"));
        RegisterUser.setEmail(principal.getAttribute("email"));
        RegisterUser.setAvatar_url(principal.getAttribute("avatar_url"));
        RegisterUser.setGiven_name(principal.getAttribute("given_name"));
        RegisterUser.setLogin(principal.getAttribute("login"));
        RegisterUser.setName(principal.getAttribute("name"));
        RegisterUser.setPicture(principal.getAttribute("picture"));
        RegisterUser.setType(principal.getAttribute("type"));
        RegisterUser.setUrl(principal.getAttribute("url"));
        RegisterUser.setCreated_at(principal.getAttribute("created_at"));
        RegisterUser.setUpdated_at(principal.getAttribute("updated_at"));
        RegisterUser.setLocation(principal.getAttribute("location"));
        RegisterUser.setRepos_url(principal.getAttribute("repos_url"));
        userRepository.save(RegisterUser); //save db
        return "index";
    }

    @GetMapping("/lists")
    public String getUsersList(Model model) {
        List<User> allUsers = userRepository.findAll();
        model.addAttribute("userList", allUsers);
        return "users";
    }

    @GetMapping("/getOne")
    public String getUser(Model model) {
        Optional<User> getByLogin = userRepository
                .findByLogin(
                        String.valueOf(model.getAttribute("login")));
        model.addAttribute("user", getByLogin);
        return "user";
    }


}
