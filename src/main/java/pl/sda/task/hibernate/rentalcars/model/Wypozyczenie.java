package pl.sda.task.hibernate.rentalcars.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "wypozyczenie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @CreationTimestamp
    @Column(name = "data_wypozyczenia")
    private LocalDateTime dataWypozyczenia;
    @Column(name = "data_koncowa_wypozyczenia")
    private LocalDateTime dataKoncaWypozyczenia;
    @CreationTimestamp
    @Column(name = "godzima_wypozyczenia")
    private LocalDateTime godzinaWypozyczenia;
    @Column(name = "godzina_koncowa_wypozyczenia")
    private LocalDateTime godzinaKoncaWypozyczenia;
    @Formula("(select samochod.stawka_godzinowa_wypozyczenia from samochod where samochod.id = samochod_id)")
    private double cenaWynajecia;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "samochod_id")
    private Samochod samochod;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "klient_id")
    private Klient klient;

    @OneToOne(mappedBy = "wypozyczenie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;
}
