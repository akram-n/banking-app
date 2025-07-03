package com.practice.banking.service;

import com.practice.banking.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDto);
    AccountDTO getAccountById(Long id);
    AccountDTO deposit(Long id, double amount);
    AccountDTO withdraw(Long id, double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(Long id);
}
