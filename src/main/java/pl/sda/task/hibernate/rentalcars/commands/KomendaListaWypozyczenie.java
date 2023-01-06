package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Wypozyczenie;

import java.util.List;

public class KomendaListaWypozyczenie implements Komenda {
    private final DataAccessObject<Wypozyczenie> dataAccessObject;

    public KomendaListaWypozyczenie() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista wypozyczenie";
    }

    @Override
    public void obsluga() {
        List<Wypozyczenie> wypozyczenia = dataAccessObject.findAll(Wypozyczenie.class);
        wypozyczenia.forEach(System.out::println);
    }
}
