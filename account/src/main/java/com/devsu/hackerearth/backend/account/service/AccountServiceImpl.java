package com.devsu.hackerearth.backend.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.account.model.Account;
import com.devsu.hackerearth.backend.account.model.dto.AccountDto;
import com.devsu.hackerearth.backend.account.model.dto.PartialAccountDto;
import com.devsu.hackerearth.backend.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        // Get all accounts
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> result = new ArrayList();
        for (Account account : accounts) {
            result.add(mapperToAccount(account));
        }
        return result;
    }

    private AccountDto mapperToAccount(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setActive(account.isActive());
        accountDto.setNumber(account.getNumber());
        accountDto.setType(account.getType());
        accountDto.setInitialAmount(account.getInitialAmount());
        accountDto.setClientId(account.getClientId());

        return accountDto;
    }

    private Account mapperToAccountDto(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setActive(accountDto.isActive());
        account.setNumber(accountDto.getNumber());
        account.setType(accountDto.getType());
        account.setInitialAmount(accountDto.getInitialAmount());
        account.setClientId(accountDto.getClientId());

        return account;
    }

    @Override
    public Optional<AccountDto> getById(Long id) {
        // Get accounts by id
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            return null;
        }
        return account.map(this::mapperToAccount);
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        // Create account
        Account client = mapperToAccountDto(accountDto);
        return mapperToAccount(accountRepository.save(client));
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {
        // Update account
        Account existAccount = accountRepository.findById(id)
                .orElseThrow(null);
        if (existAccount == null) {
            return null;
        }
        existAccount.setActive(accountDto.isActive());
        existAccount.setNumber(accountDto.getNumber());
        existAccount.setType(accountDto.getType());
        existAccount.setInitialAmount(accountDto.getInitialAmount());
        existAccount.setClientId(accountDto.getClientId());

        Account updateAccount = accountRepository.save(existAccount);

        return mapperToAccount(updateAccount);
    }

    @Override
    public AccountDto partialUpdate(Long id, PartialAccountDto partialAccountDto) {
        Account existAccount = accountRepository.findById(id)
                .orElseThrow(null);
        if (existAccount == null) {
            return null;
        }
        existAccount.setActive(partialAccountDto.isActive());

        Account updateAccount = accountRepository.save(existAccount);

        return mapperToAccount(updateAccount);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

}
