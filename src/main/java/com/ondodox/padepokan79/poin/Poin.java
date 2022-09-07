package com.ondodox.padepokan79.poin;

import com.ondodox.padepokan79.account.Account;
import lombok.Data;

@Data
public class Poin {
    private Account account;
    private Integer poins;
}