package nl.dami.fintrack.service;

import nl.dami.fintrack.model.Transaction;
import nl.dami.fintrack.repository.TransactionRepository;
import nl.dami.fintrack.util.SessionManager;

import java.util.List;
import java.util.UUID;

public class TransactionService {
    private final TransactionRepository transactionRepository = new TransactionRepository();

    public boolean addTransaction(double amount, String type, String category, String description, String date){
        if (SessionManager.getCurrentUserId() == null) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }
        if (type == null || type.isBlank()) {
            return false;
        }

        if(category == null || category.isBlank()){
            return false;
        }
        if (date == null || date.isBlank()){
            return false;
        }

        Transaction transaction = new Transaction (
            UUID.randomUUID().toString(),
            SessionManager.getCurrentUserId(),
            amount, type,
            category,
            description,
            date
        );
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getCurrentUserTransactions() {
        String userId = SessionManager.getCurrentUserId();

        if(userId == null){
            return List.of();
        }

        return transactionRepository.findByUserId(userId);
    }
}
