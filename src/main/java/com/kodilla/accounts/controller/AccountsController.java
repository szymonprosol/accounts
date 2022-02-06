package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final DbService service;
    private final AccountMapper accountMapper;

    @GetMapping
    public List<AccountDto> getAccountsByCustomerId(@RequestParam Long customerId) {
        List<Account> accounts = service.getAccountsById(customerId);
        return accountMapper.mapToAccountDtoList(accounts);
    }
}
