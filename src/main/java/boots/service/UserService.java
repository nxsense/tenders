package boots.service;

import boots.entity.User;

import java.util.Optional;

public interface UserService {
    User createNewUser(User user);
    Optional<User> findById(int id);
    User findUserByName(String name);
}
