package pl.sda.task.hibernate.rentalcars;

import pl.sda.task.hibernate.rentalcars.commands.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = List.of(new KomendaDodajSamochod(), new KomendaListaSamochod(), new KomendaAktualizujSamochod(), new KomendaUsunSamochod(), new KomendaDodajKlient(), new KomendaListaKlient(), new KomendaAktualizujKlient(), new KomendaUsunKlient(), new KomendaDodajWypozyczenie(), new KomendaListaWypozyczenie(), new KomendaUsunWypozyczenie(), new KomendaAktualizujWypozyczenie(), new KomendaDodajZwrot(), new KomendaListaZwrot(), new KomendaAktualizujZwrot(), new KomendaUsunZwrot());

        System.out.println("Lista dostepnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));
        System.out.println("\nPodaj komende");
        String komenda = Komenda.scanner.nextLine();

        listaKomend.stream().filter(dostepnaKomenda -> dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)).findFirst().ifPresent(Komenda::obsluga);
    }
}
