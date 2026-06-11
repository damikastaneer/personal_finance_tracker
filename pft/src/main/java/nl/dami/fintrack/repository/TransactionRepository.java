package nl.dami.fintrack.repository;

import nl.dami.fintrack.database.DatabaseManager;
import nl.dami.fintrack.model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public boolean save(Transaction transaction) {
        String sql = """
                INSERT INTO transactions (
                id, user_id, amount, type, category, description, date
                ) VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, transaction.getId());
            statement.setString(2, transaction.getUserId());
            statement.setDouble(3, transaction.getAmount());
            statement.setString(4, transaction.getType());
            statement.setString(5, transaction.getCategory());
            statement.setString(6, transaction.getDescription());
            statement.setString(7, transaction.getDate());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Could not save transaction: " + e.getMessage());
            return false;
        }
    }

    public List<Transaction> findByUserId(String userId) {
        String sql = """
                SELECT * FROM transactions
                WHERE user_id = ?
                ORDER BY date DESC
                """;

        List<Transaction> transactions = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                transactions.add(new Transaction(
                        resultSet.getString("id"),
                        resultSet.getString("user_id"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("type"),
                        resultSet.getString("category"),
                        resultSet.getString("description"),
                        resultSet.getString("date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Could not load transaction: " + e.getMessage());
        }

        return transactions;
    }
}
