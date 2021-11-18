package com.codegym.service;

import com.codegym.model.Account;

import java.util.List;

public interface IAccountService extends IGeneralService<Account> {
    Account findByUsername (String username);

    List<Account> findByFlag (Boolean flag);
}
