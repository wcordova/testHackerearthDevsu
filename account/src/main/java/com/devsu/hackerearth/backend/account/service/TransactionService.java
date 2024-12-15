package com.devsu.hackerearth.backend.account.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.devsu.hackerearth.backend.account.model.dto.BankStatementDto;
import com.devsu.hackerearth.backend.account.model.dto.TransactionDto;

public interface TransactionService {

    public List<TransactionDto> getAll();
	public Optional<TransactionDto> getById(Long id);
	public TransactionDto create(TransactionDto transactionDto);
    public List<BankStatementDto> getAllByAccountClientIdAndDateBetween(Long clientId, @Param("dateTransactionStart") Date dateTransactionStart, @Param("dateTransactionEnd") Date dateTransactionEnd);
    public Optional<TransactionDto> getLastByAccountId(Long accountId);
}
