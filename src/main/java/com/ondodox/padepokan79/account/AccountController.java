package com.ondodox.padepokan79.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("accounts", accountRepository.findAll());
        return "account/_index";
    }

    @PostMapping
    public String store(Account account){
        accountRepository.save(account);
        return "redirect:/account";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("account", new Account());
        return "account/_create";
    }
}
