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
@Table(name = "klient")
@NoArgsConstructor
@AllArgsConstructor
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private String imie;
    private String nazwisko;

    @Column(unique=true)
    private String nip;
    private String telefon;
    private String email;


    @OneToMany(mappedBy = "klient")
    private Set<Wypozyczenie> wypozyczenia;
}
