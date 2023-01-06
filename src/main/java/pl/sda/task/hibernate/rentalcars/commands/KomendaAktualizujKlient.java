package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Klient;

public class KomendaAktualizujKlient implements Komenda {
    private final DataAccessObject<Klient> dataAccessObject;

    public KomendaAktualizujKlient() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id klienta");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.notExists(Klient.class, id)) {
            System.err.println("Błąd, klient o takim id nie istnieje!");
            return;
        }

        System.out.println("Podaj imie klienta");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko klienta");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Podaj nip klienta");
        String nip = Komenda.scanner.nextLine();

        Klient klient = Klient.builder().id(id).imie(imie).nazwisko(nazwisko).nip(nip).build();

        dataAccessObject.update(Klient.class, id, klient);
    }
}
