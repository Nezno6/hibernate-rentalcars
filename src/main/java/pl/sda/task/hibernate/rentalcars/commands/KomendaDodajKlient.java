package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Klient;

public class KomendaDodajKlient implements Komenda {
    private final DataAccessObject<Klient> dataAccessObject;

    public KomendaDodajKlient() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj klient";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie klienta");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko klienta");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Podaj nip klienta");
        String nip = Komenda.scanner.nextLine();

        System.out.println("Podaj email klienta");
        String email = Komenda.scanner.nextLine();

        System.out.println("Podaj telefon klienta");
        String telefon = Komenda.scanner.nextLine();

        Klient klient = Klient.builder().imie(imie).nazwisko(nazwisko).nip(nip).email(email).telefon(telefon).build();

        dataAccessObject.insert(klient);
    }
}
