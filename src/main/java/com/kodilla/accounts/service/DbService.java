package com.kodilla.accounts.service;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DbService {

    private final AccountRepository repository;

    public List<Account> getAccountsById(final Long customerId) {
        return repository.findAll().stream()
                .filter(account -> account.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }
}
