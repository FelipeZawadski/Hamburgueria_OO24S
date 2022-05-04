package br.edu.utfpr.hamburgueria_oo24s.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Stock {

    @Id @GeneratedValue
    private Long id;

    @OneToOne @Getter
    private Item item;

    private Double quantity;
    private LocalDateTime lastTransaction;

    public Stock updateIncrementQuantity(Double quantity){
        this.quantity += quantity;
        this.lastTransaction = LocalDateTime.now();
        return this;
    }
}
