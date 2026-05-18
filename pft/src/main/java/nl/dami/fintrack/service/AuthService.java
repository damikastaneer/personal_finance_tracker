package nl.dami.fintrack.service;

import nl.dami.fintrack.model.User;
import nl.dami.fintrack.repository.UserRepository;
import nl.dami.fintrack.util.PasswordUtil;

import java.util.UUID;

public class AuthService {

    private final UserRepository userRepository = new UserRepository();

    public boolean register(String f_name, String l_name, String username, String email, String password, String confirmPassword) {
        if (f_name == null || f_name.isBlank()) {
            return false;
        }

        if (l_name == null || l_name.isBlank()) {
            return false;
        }

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

        User user = new User(id, f_name, l_name, username, email, passwordHash);

        return userRepository.save(user);
    }

    public boolean login(String identifier, String password){
        if (identifier == null || identifier.isBlank()){
            return false;
        }
        if(password == null || password.isBlank()){
            return false;
        }

        User user;

        if (identifier.contains("@")){
            user = userRepository.findByEmail(identifier);
        } else{
            user = userRepository.findByUsername(identifier);
        }

        if (user == null){
            return false;
        }

        String passwordHash = PasswordUtil.hashPassword(password);

        return passwordHash.equals(user.getPasswordHash());
    }
}
