package pl.sda.task.hibernate.rentalcars;

import pl.sda.task.hibernate.rentalcars.commands.Komenda;
import pl.sda.task.hibernate.rentalcars.commands.KomendaAddCar;
import pl.sda.task.hibernate.rentalcars.commands.KomendaAktualizujSamochod;
import pl.sda.task.hibernate.rentalcars.commands.KomendaListaSamochod;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Komenda> listaKomend = List.of(
            new KomendaAddCar(),
            new KomendaListaSamochod(),
            new KomendaAktualizujSamochod()
    );

        System.out.println("Lista dostepnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));
        System.out.println("\nPodaj komende");
    String komenda = Komenda.scanner.nextLine();

        listaKomend
                .stream()
                .filter(dostepnaKomenda -> dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda))
            .findFirst().ifPresent(Komenda::obsluga);
}
}
