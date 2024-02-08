package it.epicode.w5d1pratica.repository;

import it.epicode.w5d1pratica.bean.Pizza;
import it.epicode.w5d1pratica.bean.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzeRepository extends JpaRepository<Pizza, Integer> {


    @Query("select p from Pizza p where p.calorie = :calorie")
    public List<Pizza> findCalorie(int calorie);

}
