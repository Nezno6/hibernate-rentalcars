package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Samochod;

public class KomendaAktualizujSamochod implements Komenda{
    private final DataAccessObject<Samochod> dataAccessObject;

    public KomendaAktualizujSamochod() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id samochodu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.notExists(Samochod.class, id)) {
            System.err.println("Błąd, samochod o takim id nie istnieje!");
            return;
        }

        System.out.println("Podaj nrRej samochodu");
        String nrRej = Komenda.scanner.nextLine();

        System.out.println("Podaj marke samochodu");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model samochodu");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj ilosc miejsc pojazdu");
        int miejsca = Integer.parseInt(Komenda.scanner.nextLine());

        Samochod samochod = Samochod
                .builder()
                .id(id)
                .nr_rej(nrRej)
                .marka(marka)
                .model(model)
                .ilosc_miejsc(miejsca)
                .build();

        dataAccessObject.update(Samochod.class, id, samochod);
    }
}
