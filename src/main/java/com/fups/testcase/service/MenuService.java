package com.fups.testcase.service;

import com.fups.testcase.entity.menu.Accounts;
import com.fups.testcase.entity.menu.Campaigns;
import com.fups.testcase.entity.menu.Cards;
import com.fups.testcase.entity.menu.Transactions;
import com.fups.testcase.repository.AccountsRepository;
import com.fups.testcase.repository.CampaignsRepository;
import com.fups.testcase.repository.CardRepository;
import com.fups.testcase.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MenuService {

    private final AccountsRepository accountsRepository;
    private final CampaignsRepository campaignsRepository;
    private final CardRepository cardsRepository;
    private final TransactionsRepository transactionsRepository;

    public MenuService(
            AccountsRepository accountsRepository,
            CampaignsRepository campaignsRepository,
            CardRepository cardsRepository,
            TransactionsRepository transactionsRepository
    ) {
        this.accountsRepository = accountsRepository;
        this.campaignsRepository = campaignsRepository;
        this.cardsRepository = cardsRepository;
        this.transactionsRepository = transactionsRepository;
    }

    public void createAccount(Accounts accounts) {
        accountsRepository.save(accounts);
    }

    public void createCampaigns(Campaigns campaign) {
        campaignsRepository.save(campaign);
    }

    public void createCards(Cards cards) {
        cardsRepository.save(cards);
    }

    public void createTransactions(Transactions transaction) {
        transactionsRepository.save(transaction);
    }

    public HashMap<String, List<?>> getAllMenuList() {
        List<Accounts> accountsList = accountsRepository.findAll();
        List<Campaigns> campaignsList = campaignsRepository.findAll();
        List<Cards> cardsList = cardsRepository.findAll();
        List<Transactions> transactionsList = transactionsRepository.findAll();
        HashMap<String, List<?>> newHash = new HashMap<>();
        newHash.put("accountList", accountsList);
        newHash.put("campaingList", campaignsList);
        newHash.put("cardsList", cardsList);
        newHash.put("transactionList", transactionsList);
        return newHash;
    }
}
