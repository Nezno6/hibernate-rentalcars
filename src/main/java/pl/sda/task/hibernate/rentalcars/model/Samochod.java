package pl.sda.task.hibernate.rentalcars.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Samochod {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
        private Long id;
        private String nr_rej;
        private String marka;
        private String model;
        private int ilosc_miejsc;
}
