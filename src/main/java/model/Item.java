package model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString //para não imprimir endereço de memoria
public class Item {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @Column(unique = true)
    private String description;

    @Column(precision = 2)
    private double value;

    @Column(nullable = true)
    private Integer stock;
}
