package boots.service.impl;

import boots.entity.User;
import boots.repository.UserRepository;
import boots.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createNewUser(User user) {
        String password = user.getPassword();
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(password);
        user.setName(user.getName());
        return userRepository.save(user);
    }
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
