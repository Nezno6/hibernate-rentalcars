package pl.sda.task.hibernate.rentalcars.commands;

import java.util.Scanner;

public interface Komenda {
    Scanner scanner = new Scanner(System.in);

    String getKomenda();

    void obsluga();
}
