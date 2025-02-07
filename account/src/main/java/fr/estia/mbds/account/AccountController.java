package fr.estia.mbds.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;

    @Autowired
    public AccountController(AccountRepository accountRepository, CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {

        List<Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
            account.setCustomer(customerClient.getCustomerById(account.getCustomerId())); // Récuperation les données de customer
        });
        return accountList;

    }

    @GetMapping("/account/{id}")

    public Account getAccountById(@PathVariable String id) {

        return accountRepository.findById(id).orElse(null);
    }

}
