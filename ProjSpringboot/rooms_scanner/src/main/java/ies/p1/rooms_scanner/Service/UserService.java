package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.User;
import ies.p1.rooms_scanner.Repository.UserRepository;
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