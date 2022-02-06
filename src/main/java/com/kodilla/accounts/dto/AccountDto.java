package com.kodilla.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    //private Long customerId;
    private String nrb;
    private String currency;
    private double availableFunds;
}