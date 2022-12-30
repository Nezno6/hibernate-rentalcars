package pl.sda.task.hibernate.rentalcars.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataWypozyczenia;
    private LocalDateTime dataKoncaWypozyczenia;
    private double cenaWynajecia;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Samochod samochod;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Klient klient;
}
