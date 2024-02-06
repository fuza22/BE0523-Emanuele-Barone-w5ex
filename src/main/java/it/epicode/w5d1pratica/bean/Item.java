package it.epicode.w5d1pratica.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class Item {

    private String nome;
    private int calorie;
    private double prezzo;
}
