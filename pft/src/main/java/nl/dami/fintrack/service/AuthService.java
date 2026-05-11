package nl.dami.fintrack.service;

import nl.dami.fintrack.model.User;
import nl.dami.fintrack.repository.UserRepository;
import nl.dami.fintrack.util.PasswordUtil;

import java.util.UUID;

public class AuthService {

    private final UserRepository userRepository = new UserRepository();

    public boolean register(String username, String email, String password, String confirmPassword) {
        if (username == null || username.isBlank()) {
            return false;
        }

        if (email == null || email.isBlank()) {
            return false;
        }

        if (password == null || password.length() < 6) {
            return false;
        }

        if (!password.equals(confirmPassword)) {
            return false;
        }

        String id = UUID.randomUUID().toString();
        String passwordHash = PasswordUtil.hashPassword(password);

        User user = new User(id, username, email, passwordHash);

        return userRepository.save(user);
    }
}
