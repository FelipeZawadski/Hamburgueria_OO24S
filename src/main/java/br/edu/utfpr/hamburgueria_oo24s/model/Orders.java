package br.edu.utfpr.hamburgueria_oo24s.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Item item;
}
