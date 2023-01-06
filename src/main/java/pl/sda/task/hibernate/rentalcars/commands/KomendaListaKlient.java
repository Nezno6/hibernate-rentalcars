package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Klient;

import java.util.List;

public class KomendaListaKlient implements Komenda {
    private final DataAccessObject<Klient> dataAccessObject;

    public KomendaListaKlient() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista klient";
    }

    @Override
    public void obsluga() {
        List<Klient> klientow = dataAccessObject.findAll(Klient.class);
        klientow.forEach(System.out::println);
    }
}
