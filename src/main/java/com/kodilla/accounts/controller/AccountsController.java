package com.kodilla.accounts.controller;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import com.kodilla.accounts.mapper.AccountMapper;
import com.kodilla.accounts.service.DbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final DbService service;
    private final AccountMapper accountMapper;

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    @GetMapping
    public List<AccountDto> getAccountsByCustomerId(@RequestParam("customerId") Long customerId) {
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        List<Account> accounts = service.getAccountsById(customerId);
        return accountMapper.mapToAccountDtoList(accounts);
    }
}
