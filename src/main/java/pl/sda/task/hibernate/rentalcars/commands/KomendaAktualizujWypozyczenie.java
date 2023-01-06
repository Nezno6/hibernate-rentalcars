package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Klient;
import pl.sda.task.hibernate.rentalcars.model.Samochod;
import pl.sda.task.hibernate.rentalcars.model.Wypozyczenie;

import java.time.LocalDateTime;
import java.util.Optional;

public class KomendaAktualizujWypozyczenie implements Komenda {

    private final DataAccessObject<Wypozyczenie> dataAccessObjectWypozyczenie;
    private final DataAccessObject<Klient> dataAccessObjectKlient;
    private final DataAccessObject<Samochod> dataAccessObjectSamochod;

    public KomendaAktualizujWypozyczenie() {
        this.dataAccessObjectWypozyczenie = new DataAccessObject<>();
        this.dataAccessObjectKlient = new DataAccessObject<>();
        this.dataAccessObjectSamochod = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj wypozyczenie";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id wypozyczenia");
        String idStringWypozyczenie = Komenda.scanner.nextLine();
        Long idWypozyczenia = Long.parseLong(idStringWypozyczenie);

        if (dataAccessObjectWypozyczenie.find(Wypozyczenie.class, idWypozyczenia).isEmpty()) {
            System.err.println("Błąd, wypozyczenie o takim id nie istnieje!");
            return;
        }

        System.out.println("Podaj id klienta wypozyczajacego samochod");
        String idStringKlient = Komenda.scanner.nextLine();
        Long idKlienta = Long.parseLong(idStringKlient);

        Optional<Klient> klientOptional = dataAccessObjectKlient.find(Klient.class, idKlienta);
        if (klientOptional.isEmpty()) {
            System.err.println("Klient nie istnieje");
            return;
        }

        System.out.println("Podaj id wypozyczonego samochodu");
        String idSomochoduString = Komenda.scanner.nextLine();
        Long idSamochodu = Long.parseLong(idSomochoduString);

        Optional<Samochod> samochodOptional = dataAccessObjectSamochod.find(Samochod.class, idSamochodu);
        if (samochodOptional.isEmpty()) {
            System.err.println("Samochod nie istnieje");
            return;
        }

        System.out.println("Podaj ilosc dni wypozyczenia:");
        String iloscDniWypozyczenia = Komenda.scanner.nextLine();
        LocalDateTime dataKoncaWypozyczenia = LocalDateTime.from(LocalDateTime.now()).plusDays(Integer.parseInt(iloscDniWypozyczenia));

        double stawkaGodzinowa = 8.50;
        System.out.println("Czy chcesz zmienic stawke godzinowa (T/N): ");
        System.out.println("Aktualna stawka godzinowa w zlotych: " + stawkaGodzinowa);
        String odpStawkaGodzinowa = Komenda.scanner.nextLine();
        if (odpStawkaGodzinowa.equalsIgnoreCase("t")) {
            System.out.println("Podaj aktualna stawke godzinowa: ");
            String newStawkaGodzinowa = Komenda.scanner.nextLine();
            stawkaGodzinowa = Double.parseDouble(newStawkaGodzinowa);
            System.out.println("Nowa stawka godzinowa to " + newStawkaGodzinowa);
        }

        Wypozyczenie wypozyczenie = Wypozyczenie.builder().id(idWypozyczenia).dataWypozyczenia(dataAccessObjectWypozyczenie.find(Wypozyczenie.class, idWypozyczenia).get().getDataWypozyczenia()).dataKoncaWypozyczenia(dataKoncaWypozyczenia).cenaWynajecia(Integer.parseInt(iloscDniWypozyczenia) * stawkaGodzinowa).samochod(samochodOptional.get()).klient(klientOptional.get()).build();

        dataAccessObjectWypozyczenie.update(Wypozyczenie.class, idWypozyczenia, wypozyczenie);
    }

}
