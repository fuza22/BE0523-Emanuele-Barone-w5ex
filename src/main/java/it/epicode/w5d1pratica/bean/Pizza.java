package it.epicode.w5d1pratica.bean;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
public class Pizza extends Item{


    @ManyToMany(mappedBy = "pizza", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Topping> toppings;

    @Override
    public String toString() {
        return "Pizza{" + super.toString() +
                "toppings=" + toppings +
                '}';
    }
}
