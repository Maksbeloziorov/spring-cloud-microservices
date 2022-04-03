package com.javastart.account.service;

import com.javastart.account.entity.Account;
import com.javastart.account.exception.AccountNotFoundException;
import com.javastart.account.repository.AccountRepositoory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AccountService {

    private AccountRepositoory accountRepositoory;

    @Autowired
    public AccountService(AccountRepositoory accountRepositoory) {
        this.accountRepositoory = accountRepositoory;
    }

    public Account getAccountById(Long accountId) {
        return accountRepositoory.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Unable to find account with id: " + accountId));
    }

    public Long createAccount(String name, String email, String phone, List<Long> bills) {
        Account account = new Account(name, email, phone, OffsetDateTime.now(), bills);
        return accountRepositoory.save(account).getAccountId();
    }

    public Account updateAccount(Long accountId, String name, String email, String phone, List<Long> bills) {
        Account account = new Account();
        account.setAccountId(accountId);
        account.setName(name);
        account.setBills(bills);
        account.setEmail(email);
        account.setPhone(phone);
        return accountRepositoory.save(account);

    }

    public Account deleteAccount(Long accountId){
        Account deletedAccount = getAccountById(accountId);
        accountRepositoory.deleteById(accountId);
        return deletedAccount;
    }
}
