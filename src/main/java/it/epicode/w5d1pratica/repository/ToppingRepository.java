package it.epicode.w5d1pratica.repository;

import it.epicode.w5d1pratica.bean.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {

    public List<Topping> findByNome(String nome);

}
