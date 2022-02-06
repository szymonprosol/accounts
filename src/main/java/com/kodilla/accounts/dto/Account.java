package com.kodilla.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "NRB")
    private String nrb;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "AVAILABLE_FUNDS")
    private double availableFunds;
}