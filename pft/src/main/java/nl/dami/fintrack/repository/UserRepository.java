package nl.dami.fintrack.repository;

import nl.dami.fintrack.database.DatabaseManager;
import nl.dami.fintrack.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public boolean save(User user) {
        String sql = """
                INSERT INTO users (id, f_name, l_name, username, email, password_hash)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPasswordHash());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not save user: " + e.getMessage());
            return false;
        }
    }

    public User findByEmail(String email){
        String sql = " SELECT * FROM users WHERE email = ? ";

        try(Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            var resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new User(
                        resultSet.getString("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password_hash")
                );
            }

        } catch (SQLException e) {
            System.out.println("Could not find user: " + e.getMessage());
        }
        return null;
    }
}
