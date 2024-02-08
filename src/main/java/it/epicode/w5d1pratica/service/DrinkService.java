package it.epicode.w5d1pratica.service;

import it.epicode.w5d1pratica.bean.Drink;
import it.epicode.w5d1pratica.bean.Pizza;
import it.epicode.w5d1pratica.bean.Topping;
import it.epicode.w5d1pratica.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    
    @Autowired
    private DrinkRepository drinkRepository;

    public void salvaDrink(Drink drink){

        drinkRepository.save(drink);

    }

    public void aggiornaDrink(Drink drink){

        Drink d = drinkRepository.findById(drink.getId()).get();
        d.setNome(drink.getNome());
        d.setPrezzo(drink.getPrezzo());
        d.setCalorie(drink.getCalorie());
        drinkRepository.save(drink);

    }

    public Drink cercaDrinkPerId(int id){

        return drinkRepository.findById(id).get();

    }

    public void cancellaDrink(int id){

        drinkRepository.deleteById(id);

    }

    public List<Drink> cercaDrinkPerPrezzo(int prezzo){

        return drinkRepository.findPrezzo(prezzo);

    }



}
