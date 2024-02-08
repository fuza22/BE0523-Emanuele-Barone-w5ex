package it.epicode.w5d1pratica;

import it.epicode.w5d1pratica.bean.*;
import it.epicode.w5d1pratica.service.DrinkService;
import it.epicode.w5d1pratica.service.PizzeService;
import it.epicode.w5d1pratica.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class Runner1 implements CommandLineRunner {

    @Autowired
    private PizzeService pizzeService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private ToppingService toppingService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Primo runner");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d1praticaApplication.class);

//
//        Ordine ordine1 = ctx.getBean("ordine1", Ordine.class);
//
//        System.out.println(ordine1);
//
        Topping t1 = ctx.getBean("mozzarella", Topping.class);
        toppingService.salvaTopping(t1);

        Pizza p1 = ctx.getBean("margherita", Pizza.class);
        pizzeService.salvaPizza(p1);

        Drink d1 = ctx.getBean("cocaCola", Drink.class);
        drinkService.salvaDrink(d1);

        System.out.println("Topping cercati per nome:");
        toppingService.cercaToppingPerNome("Mozzarella").stream().forEach(System.out::println);


        System.out.println("Pizze cercate per calorie:");

        pizzeService.cercaPizzaPerCalorie(200).stream().forEach(System.out::println);

        System.out.println("Drink cercati per prezzo:");

        drinkService.cercaDrinkPerPrezzo(2).stream().forEach(System.out::println);

    }
}