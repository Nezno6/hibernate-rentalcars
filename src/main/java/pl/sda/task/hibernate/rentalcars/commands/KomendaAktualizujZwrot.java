package pl.sda.task.hibernate.rentalcars.commands;

import pl.sda.task.hibernate.rentalcars.database.DataAccessObject;
import pl.sda.task.hibernate.rentalcars.model.Wypozyczenie;
import pl.sda.task.hibernate.rentalcars.model.Zwrot;

import java.time.LocalDateTime;

public class KomendaAktualizujZwrot implements Komenda{

    private final DataAccessObject<Zwrot> dataAccessObjectZwrot;

    public KomendaAktualizujZwrot() {
        this.dataAccessObjectZwrot = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj zwrot";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id zwrotu");
        String idStringZwrotu = Komenda.scanner.nextLine();
        Long idZwrot = Long.parseLong(idStringZwrotu);

        Zwrot oldZwrot;
        if (dataAccessObjectZwrot.find(Zwrot.class, idZwrot).isEmpty()) {
            System.err.println("Błąd, zwrot o takim id nie istnieje!");
            return;
        } else {
            oldZwrot = dataAccessObjectZwrot.find(Zwrot.class, idZwrot).get();
        }

        System.out.println("Czy chcesz wprowadzić date zwrotu samochodu: T/N ");
        String odpZmianaDatyZwrotu = Komenda.scanner.nextLine();

        LocalDateTime dataZwrotu;
        if (odpZmianaDatyZwrotu.equalsIgnoreCase("t")){
            dataZwrotu = LocalDateTime.now();
            System.out.println("Data zwrotu została zaktualizowana " + dataZwrotu);
        } else {
            dataZwrotu = oldZwrot.getDataZwrotu();
            System.out.println("Data zwrotu pozostała bez zmian " + dataZwrotu);
        }

        System.out.println("Wprowadz tresc notatki: ");
        String notatka = Komenda.scanner.nextLine();

        Zwrot zwrot = Zwrot
                .builder()
                .id(idZwrot)
                .dataZwrotu(dataZwrotu)
                .notatka(notatka)
                .wypozyczenie(oldZwrot.getWypozyczenie())
                .build();

        dataAccessObjectZwrot.update(Zwrot.class, idZwrot, zwrot);
    }
}
