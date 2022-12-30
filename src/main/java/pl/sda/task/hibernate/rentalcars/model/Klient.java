package pl.sda.task.hibernate.rentalcars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private String imie;
    private String nazwisko;
    private String nip;

    @OneToMany(mappedBy = "klient")
    private Set<Wypozyczenie> wypozyczenia;
}
