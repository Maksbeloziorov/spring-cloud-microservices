package com.javastart.account.repository;

import com.javastart.account.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepositoory extends CrudRepository<Account, Long> {

}
