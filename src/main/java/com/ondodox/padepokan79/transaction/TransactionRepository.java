package com.ondodox.padepokan79.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByDateGreaterThanEqualAndDateLessThanEqualAndAccount_AccountId(Date date, Date date2, Integer accountId);
}
