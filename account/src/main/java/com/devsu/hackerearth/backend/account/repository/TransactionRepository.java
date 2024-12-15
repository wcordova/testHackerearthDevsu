package com.devsu.hackerearth.backend.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsu.hackerearth.backend.account.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM Transactions t WHERE t.accountId = : accountId ORDER BY t.date DESC LIMIT 1", nativeQuery = true)
    Optional<Transaction> findLastTransactionByAccountId(Long accountId);

}
