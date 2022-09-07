package com.ondodox.padepokan79.transaction;


import com.ondodox.padepokan79.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("transaction")
public class TransactionController {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("accounts", accountRepository.findAll());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "transaction/_index";
    }

    @PostMapping
    public String store(Transaction transaction){
        transactionRepository.save(transaction);
        return "redirect:/transaction";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("accounts", accountRepository.findAll());
        return "transaction/_create";
    }

    @GetMapping("search")
    public String search(@RequestParam(required = false) Integer accountId, @RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, Model model){
        model.addAttribute("accounts", accountRepository.findAll());
        try{
            model.addAttribute("transactions", transactionRepository.findAllByDateGreaterThanEqualAndDateLessThanEqualAndAccount_AccountId(Date.valueOf(startDate), Date.valueOf(endDate), accountId));
            model.addAttribute("start", startDate);
            model.addAttribute("end", endDate);
        }catch (Exception ignored){
            model.addAttribute("transactions", transactionRepository.findAll());
        }

        return "transaction/_search";
    }
}
