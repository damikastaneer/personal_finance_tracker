package nl.dami.fintrack.repository;

import nl.dami.fintrack.database.DatabaseManager;
import nl.dami.fintrack.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public boolean save(User user) {
        String sql = """
                INSERT INTO users (id, username, email, password_hash)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPasswordHash());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not save user: " + e.getMessage());
            return false;
        }
    }
}
