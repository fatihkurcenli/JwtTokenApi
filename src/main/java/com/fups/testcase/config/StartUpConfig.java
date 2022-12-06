package com.fups.testcase.config;

import com.fups.testcase.entity.PremiumProduct;
import com.fups.testcase.entity.RollType;
import com.fups.testcase.entity.UserRequest;
import com.fups.testcase.entity.menu.Accounts;
import com.fups.testcase.entity.menu.Campaigns;
import com.fups.testcase.entity.menu.Cards;
import com.fups.testcase.entity.menu.Transactions;
import com.fups.testcase.service.MenuService;
import com.fups.testcase.service.PremiumProductsServices;
import com.fups.testcase.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpConfig implements CommandLineRunner {

    private final UserService userService;
    private final PremiumProductsServices productsServices;
    private final MenuService menuService;

    public StartUpConfig(UserService userService, PremiumProductsServices productsServices, MenuService menuService) {
        this.userService = userService;
        this.productsServices = productsServices;
        this.menuService = menuService;
    }


    @Override
    public void run(String... args) {
        userService.addUser(UserRequest.builder().nameAndSurname("Sena").email("sena@gmail.com").password("test").rollType(RollType.PREMIUM).build());
        userService.addUser(UserRequest.builder().nameAndSurname("Fatih").email("test@gmail.com").password("test").rollType(RollType.STANDARD).build());
        userService.addUser(UserRequest.builder().nameAndSurname("Fups").email("fups@gmail.com").password("test").rollType(RollType.ACCEPTED).build());

        //Premium products save instance
        productsServices.savePremiumProducts(PremiumProduct.builder().productTitle("This is title").productDescription("This is description").productImageUrl("https://img.freepik.com/free-vector/vip-with-crown-composition_1284-36184.jpg?w=2000").build());
        productsServices.savePremiumProducts(PremiumProduct.builder().productTitle("This is title2").productDescription("This is description2").productImageUrl("https://img.freepik.com/free-vector/vip-with-crown-composition_1284-36184.jpg?w=2000").build());
        productsServices.savePremiumProducts(PremiumProduct.builder().productTitle("This is title3").productDescription("This is description3").productImageUrl("https://img.freepik.com/free-vector/vip-with-crown-composition_1284-36184.jpg?w=2000").build());
        productsServices.savePremiumProducts(PremiumProduct.builder().productTitle("This is title4").productDescription("This is description4").productImageUrl("https://img.freepik.com/free-vector/vip-with-crown-composition_1284-36184.jpg?w=2000").build());

        menuService.createAccount(Accounts.builder().title("Hesap 1").build());
        menuService.createAccount(Accounts.builder().title("Hesap 2").build());
        menuService.createAccount(Accounts.builder().title("Hesap 3").build());
        menuService.createAccount(Accounts.builder().title("Hesap 4").build());

        menuService.createCampaigns(Campaigns.builder().title("Campaigns 1").build());
        menuService.createCampaigns(Campaigns.builder().title("Campaigns 2").build());
        menuService.createCampaigns(Campaigns.builder().title("Campaigns 3").build());
        menuService.createCampaigns(Campaigns.builder().title("Campaigns 4").build());


        menuService.createCards(Cards.builder().title("Cards 1").build());
        menuService.createCards(Cards.builder().title("Cards 2").build());
        menuService.createCards(Cards.builder().title("Cards 3").build());
        menuService.createCards(Cards.builder().title("Cards 4").build());


        menuService.createTransactions(Transactions.builder().title("Transactions 1").build());
        menuService.createTransactions(Transactions.builder().title("Transactions 2").build());
        menuService.createTransactions(Transactions.builder().title("Transactions 3").build());
        menuService.createTransactions(Transactions.builder().title("Transactions 4").build());

    }
}
