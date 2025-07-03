package com.practice.banking.mapper;

import com.practice.banking.dto.AccountDTO;
import com.practice.banking.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.id(),
                accountDTO.accountHolderName(),
                accountDTO.balance()
        );
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDTO;
    }
}
