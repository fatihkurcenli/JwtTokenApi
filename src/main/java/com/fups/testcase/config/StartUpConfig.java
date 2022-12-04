package com.fups.testcase.config;

import com.fups.testcase.entity.PremiumProduct;
import com.fups.testcase.entity.RollType;
import com.fups.testcase.entity.UserRequest;
import com.fups.testcase.service.PremiumProductsServices;
import com.fups.testcase.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpConfig implements CommandLineRunner {

    private final UserService userService;
    private final PremiumProductsServices productsServices;

    public StartUpConfig(UserService userService, PremiumProductsServices productsServices) {
        this.userService = userService;
        this.productsServices = productsServices;
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
    }
}
