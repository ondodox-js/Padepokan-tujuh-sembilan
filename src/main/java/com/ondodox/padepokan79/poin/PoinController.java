package com.ondodox.padepokan79.poin;


import com.ondodox.padepokan79.account.Account;
import com.ondodox.padepokan79.account.AccountRepository;
import com.ondodox.padepokan79.transaction.Description;
import com.ondodox.padepokan79.transaction.Transaction;
import com.ondodox.padepokan79.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PoinController {
    private final AccountRepository accountRepository;

    @Autowired
    public PoinController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public String index(Model model){
        List<Poin> poins = new LinkedList<>();
        for(Account account : accountRepository.findAll()){
            Poin poin = new Poin();
            poin.setAccount(account);
            int totalPoint = 0;
            for(Transaction transaction : account.getTransactions()){
                if (transaction.getDescription().equals(Description.BL)){
                    totalPoint += PoinService.countPoinBL(transaction.getAmount());
                }else if (transaction.getDescription().equals(Description.BP)){
                    totalPoint += PoinService.countPoinBP(transaction.getAmount());
                }
            }
            poin.setPoins(totalPoint);

            poins.add(poin);
        }

        model.addAttribute("poins", poins);
        return "poin/_index";
    }
}
