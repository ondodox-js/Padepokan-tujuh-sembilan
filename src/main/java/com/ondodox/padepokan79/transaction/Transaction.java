package com.ondodox.padepokan79.transaction;

import com.ondodox.padepokan79.account.Account;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Integer transactionId;

    @ManyToOne
    private Account account;

    private Date date;

    @Enumerated(EnumType.STRING)
    private Description description;

    @Enumerated(EnumType.STRING)
    private Status debitCreditStatus;

    private Long amount;
}
