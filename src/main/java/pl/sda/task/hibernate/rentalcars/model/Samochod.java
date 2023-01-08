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
    @Column(unique=true, name = "numer_rejestracyjny")
    private String nrRej;
    private String vin;
    private String marka;
    private String model;
    @Column(name = "ilosc_miejsc")
    private int iloscMiejsc;
    @Column(name = "skrzynia_biegow")
    private String skrzyniaBiegow;
    private String silnik;
    @Column(name = "klasa_samochodu")
    private String klasaPojazdu;
    @Column(name = "dostepna_klimatyzacja")
    private Boolean klimatyzacja;
    @Column(name = "stawka_godzinowa_wypozyczenia")
    private double stawkaGodzinowaWynajecia;

    @OneToMany(mappedBy = "samochod")
    private Set<Wypozyczenie> wypozyczenia;
}
