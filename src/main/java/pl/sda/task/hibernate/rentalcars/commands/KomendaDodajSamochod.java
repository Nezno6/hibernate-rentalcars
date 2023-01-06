package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Samochod;

public class KomendaDodajSamochod implements Komenda {
    private final DataAccessObject<Samochod> dataAccessObject;

    public KomendaDodajSamochod() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj samochod";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nrRej samochodu");
        String nrRej = Komenda.scanner.nextLine();

        System.out.println("Podaj marke samochodu");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model samochodu");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj ilosc miejsc pojazdu");
        int miejsca = Integer.parseInt(Komenda.scanner.nextLine());

        Samochod samochod = Samochod.builder().nrRej(nrRej).marka(marka).model(model).iloscMiejsc(miejsca).build();

        dataAccessObject.insert(samochod);
    }
}
