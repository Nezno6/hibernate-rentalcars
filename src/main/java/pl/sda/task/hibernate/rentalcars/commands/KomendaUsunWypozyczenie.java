package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Wypozyczenie;

public class KomendaUsunWypozyczenie implements Komenda {
    private final DataAccessObject<Wypozyczenie> dataAccessObject;

    public KomendaUsunWypozyczenie() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun wypozyczenie";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego wypozyczenia: ");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Wypozyczenie.class, id)) {
            System.out.println("Usunieto wypozyczenie");
        } else {
            System.err.println("Nie udalo sie usunac wypozyczenia");
        }
    }
}
