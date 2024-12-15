package com.devsu.hackerearth.backend.account.service;

import java.util.List;
import java.util.Optional;

import com.devsu.hackerearth.backend.account.model.dto.AccountDto;
import com.devsu.hackerearth.backend.account.model.dto.PartialAccountDto;

public interface AccountService {

    public List<AccountDto> getAll();
	public Optional<AccountDto> getById(Long id);
	public AccountDto create(AccountDto accountDto);
	public AccountDto update(Long id, AccountDto accountDto);
	public AccountDto partialUpdate(Long id, PartialAccountDto partialAccountDto);
	public void deleteById(Long id);
}
