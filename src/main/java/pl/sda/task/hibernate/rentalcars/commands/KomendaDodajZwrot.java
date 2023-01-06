package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Wypozyczenie;
import pl.sda.task.hibernate.rentalcars.model.Zwrot;

import java.time.LocalDateTime;
import java.util.Optional;

public class KomendaDodajZwrot implements Komenda {
    private final DataAccessObject<Zwrot> dataAccessObjectZwrot;
    private final DataAccessObject<Wypozyczenie> dataAccessObjectWypozyczenie;


    public KomendaDodajZwrot() {
        this.dataAccessObjectZwrot = new DataAccessObject<>();
        this.dataAccessObjectWypozyczenie = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj zwrot";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id wypozyczenia samochodu");
        String idString = Komenda.scanner.nextLine();
        Long idWypozyczenie = Long.parseLong(idString);

        Optional<Wypozyczenie> wypozyczenieOptional = dataAccessObjectWypozyczenie.find(Wypozyczenie.class, idWypozyczenie);
        if (wypozyczenieOptional.isEmpty()) {
            System.err.println("Wypozyczenie nie istnieje");
            return;
        }

        System.out.println("Wprowadz tresc notatki: ");
        String notatka = Komenda.scanner.nextLine();

        Zwrot zwrot = Zwrot.builder().dataZwrotu(LocalDateTime.now()).notatka(notatka).wypozyczenie(wypozyczenieOptional.get()).build();

        dataAccessObjectZwrot.insert(zwrot);
        System.out.println("Dodano zwrot");
    }

}
