package it.epicode.w5d1pratica.repository;

import it.epicode.w5d1pratica.bean.Drink;
import it.epicode.w5d1pratica.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {

    @Query("select d from Drink d where d.prezzo = :prezzo")
    public List<Drink> findPrezzo(int prezzo);


}
