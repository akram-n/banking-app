package com.practice.banking.controller;

import com.practice.banking.dto.AccountDTO;
import com.practice.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add account REST API
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    // Get account by REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        AccountDTO accountDTO = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

    // Deposit amount to account REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");

        AccountDTO accountDTO = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    // Withdraw amount from account REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    // Get all accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account with ID " + id + " deleted successfully.");
    }
}
