package org.demo.Tasks.service;

import lombok.Data;
import org.demo.Tasks.model.User;
import org.demo.Tasks.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@Data
public class LoginService {
    private final UserRepository userRepository;
    private final UserSession userSession;

    public boolean validateCredentials(String username, String password) {
        Optional<User> user = userRepository.getUserByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            userSession.setUsername(user.get().getUsername());
            userSession.setUserId(user.get().getUserId());
            return true;
        } else {
            return false;
        }
    }

}
