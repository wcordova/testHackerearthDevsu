package com.devsu.hackerearth.backend.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsu.hackerearth.backend.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM Accounts a WHERE a.clientId = :clientId ORDER BY a.id DESC", nativeQuery = true)
    List<Account> findAccountByClient(Long clientId);

}
