package uz.pdp.oauth_2_0.repository;

import uz.pdp.oauth_2_0.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

}
