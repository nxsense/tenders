package boots.service;

import boots.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
}
