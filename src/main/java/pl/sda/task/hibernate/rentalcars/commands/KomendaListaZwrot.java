package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Zwrot;

import java.util.List;

public class KomendaListaZwrot implements Komenda {
    private final DataAccessObject<Zwrot> dataAccessObject;

    public KomendaListaZwrot() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista zwrot";
    }

    @Override
    public void obsluga() {
        List<Zwrot> zwroty = dataAccessObject.findAll(Zwrot.class);
        zwroty.forEach(System.out::println);
    }
}
