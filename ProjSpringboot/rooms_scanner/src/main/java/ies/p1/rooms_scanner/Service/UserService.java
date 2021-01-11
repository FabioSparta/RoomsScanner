package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.User;
import ies.p1.rooms_scanner.Repository.UserRepository;
<<<<<<< Updated upstream
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean userExists() {
        return findUserByEmail(email).isPresent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User register(User user1) {
        User user2 = new User();
        modelMapper.map(user1, user2);
        return save(user2);
    }


}
>>>>>>> Stashed changes
