package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Samochod;

import java.util.List;

public class KomendaListaSamochod implements Komenda{
    private final DataAccessObject<Samochod> dataAccessObject;

    public KomendaListaSamochod() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista samochod";
    }

    @Override
    public void obsluga() {
        List<Samochod> samochody = dataAccessObject.findAll(Samochod.class);
        samochody.forEach(System.out::println);
    }
}
