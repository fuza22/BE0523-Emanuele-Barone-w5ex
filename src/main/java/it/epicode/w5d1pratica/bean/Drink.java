package it.epicode.w5d1pratica.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class Drink extends Item{

    @Override
    public String toString() {
        return "Drink:" + super.toString();
    }
}
