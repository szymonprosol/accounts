package com.kodilla.accounts.mapper;

import com.kodilla.accounts.dto.Account;
import com.kodilla.accounts.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountMapper {

    /*public Account mapToAccount(final AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getCustomerId(),
                accountDto.getNrb(),
                accountDto.getCurrency(),
                accountDto.getAvailableFunds()
        );
    }*/

    public AccountDto mapToAccountDto(final Account account) {
        return new AccountDto(
                account.getId(),
                account.getNrb(),
                account.getCurrency(),
                account.getAvailableFunds()
        );
    }

    public List<AccountDto> mapToAccountDtoList(final List<Account> accountList) {
        return accountList.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }
}
