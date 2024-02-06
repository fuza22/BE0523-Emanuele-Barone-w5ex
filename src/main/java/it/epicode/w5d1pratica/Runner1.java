package it.epicode.w5d1pratica;

import it.epicode.w5d1pratica.bean.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class Runner1 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Primo runner");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d1praticaApplication.class);


        Ordine ordine1 = ctx.getBean("ordine1", Ordine.class);

        System.out.println(ordine1);


    }
}