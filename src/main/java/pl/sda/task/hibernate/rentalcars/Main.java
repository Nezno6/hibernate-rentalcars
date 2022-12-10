package pl.sda.task.hibernate.rentalcars;

import pl.sda.task.hibernate.rentalcars.commands.Komenda;
import pl.sda.task.hibernate.rentalcars.commands.KomendaAddCar;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Komenda> listaKomend = List.of(
            new KomendaAddCar()
    );
        System.out.println("Lista dostepnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("Podaj komende");
    String komenda = Komenda.scanner.nextLine();

        listaKomend
                .stream()
                .filter(dostepnaKomenda -> dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda))
            .findFirst().ifPresent(Komenda::obsluga);
}
}
