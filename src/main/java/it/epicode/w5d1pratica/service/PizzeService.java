package it.epicode.w5d1pratica.service;

import it.epicode.w5d1pratica.bean.Pizza;
import it.epicode.w5d1pratica.bean.Topping;
import it.epicode.w5d1pratica.repository.PizzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzeService {

    @Autowired
    private PizzeRepository pizzeRepository;

    public void salvaPizza(Pizza pizza){

        pizzeRepository.save(pizza);

    }

    public void aggiornaPizza(Pizza pizza){

        Pizza p = pizzeRepository.findById(pizza.getId()).get();
        p.setNome(pizza.getNome());
        p.setPrezzo(pizza.getPrezzo());
        p.setToppings(pizza.getToppings());
        p.setCalorie(pizza.getCalorie());
        pizzeRepository.save(pizza);

    }

    public Pizza cercaPizzaPerId(int id){

        return pizzeRepository.findById(id).get();

    }

    public void cancellaPizza(int id){

        pizzeRepository.deleteById(id);

    }

    public List<Pizza> cercaPizzaPerCalorie(int calorie){

        return pizzeRepository.findCalorie(calorie);

    }

}
