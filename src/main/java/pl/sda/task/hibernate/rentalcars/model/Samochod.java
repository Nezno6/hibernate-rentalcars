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
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private String nrRej;
    private String marka;
    private String model;
    private int iloscMiejsc;

    @OneToMany(mappedBy = "samochod")
    private Set<Wypozyczenie> wypozyczenia;
}
