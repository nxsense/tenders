package boots.service;

import boots.entity.User;

import java.util.Optional;

public interface UserService {
    User createNewUser(User user);
    Optional<User> findById(Long id);
    User findUserByName(String name);
}
