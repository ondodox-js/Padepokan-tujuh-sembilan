package com.ondodox.padepokan79.account;

import com.ondodox.padepokan79.transaction.Transaction;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Integer accountId;

    private String name;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
