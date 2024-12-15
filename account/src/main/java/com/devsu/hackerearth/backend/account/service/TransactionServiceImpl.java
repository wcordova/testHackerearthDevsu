package com.devsu.hackerearth.backend.account.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.account.model.Account;
import com.devsu.hackerearth.backend.account.model.Transaction;
import com.devsu.hackerearth.backend.account.model.dto.BankStatementDto;
import com.devsu.hackerearth.backend.account.model.dto.TransactionDto;
import com.devsu.hackerearth.backend.account.repository.AccountRepository;
import com.devsu.hackerearth.backend.account.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

	public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
		this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
	}

    @Override
    public List<TransactionDto> getAll() {
        // Get all transactions
		List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionDto> result = new ArrayList();
        for (Transaction transaction : transactions) {
            result.add(mapperToTransaction(transaction));
        }
        return result;
    }

    private TransactionDto mapperToTransaction(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAccountId(transaction.getAccountId());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setBalance(transaction.getBalance());
        transactionDto.setAccountId(transaction.getAccountId());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setType(transaction.getType());

        return transactionDto;
    }

    private Transaction mapperToTransactionDto(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        //transaction.setId(transactionDto.getId());
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setBalance(transactionDto.getBalance());
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.setDate(transactionDto.getDate());
        transaction.setType(transactionDto.getType());

        return transaction;
    }

    @Override
    public Optional<TransactionDto> getById(Long id) {
        // Get transactions by id
		Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isEmpty()) {
            return null;
        }
        return transaction.map(this::mapperToTransaction);
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        // Create transaction
		Transaction transaction = mapperToTransactionDto(transactionDto);
        return mapperToTransaction(transactionRepository.save(transaction));
    }

    @Override
    public List<BankStatementDto> getAllByAccountClientIdAndDateBetween(Long clientId, Date dateTransactionStart,
            Date dateTransactionEnd) {
        List<BankStatementDto> report = new ArrayList();
        List<Account> accounts = accountRepository.findAccountByClient(clientId);
        if (accounts == null || accounts.isEmpty()) 
            return null;        
        
        for(Account account: accounts) {
            Optional<TransactionDto> lastTransaction = getLastByAccountId(account.getId());
            if (lastTransaction.isEmpty()) 
                continue; 

            BankStatementDto dto = new BankStatementDto();   
            dto.setAccountNumber(account.getNumber());
            dto.setAccountType(account.getType());
            dto.setActive(account.isActive());
            dto.setAmount(lastTransaction.get().getAmount());
            dto.setBalance(lastTransaction.get().getBalance());
            dto.setClient(account.getClientId().toString());
            dto.setDate(dateTransactionEnd);
            dto.setInitialAmount(account.getInitialAmount());
            dto.setTransactionType(lastTransaction.get().getType());     
            
            report.add(dto);
        }       
        
		return report;
    }

    @Override
    public Optional<TransactionDto> getLastByAccountId(Long accountId) {
        // If you need it
        Optional<Transaction> transaction = transactionRepository.findLastTransactionByAccountId(accountId);
        if(transaction.isEmpty()) {
            return null;
        }
        return transaction.map(this::mapperToTransaction);
    }
    
}
