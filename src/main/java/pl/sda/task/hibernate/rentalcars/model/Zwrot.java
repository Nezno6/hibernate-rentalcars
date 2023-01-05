package pl.sda.task.hibernate.rentalcars.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zwrot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataZwrotu;
    private String notatka;

    @OneToOne
    @JoinColumn(name = "wypozyczenie_id", referencedColumnName = "id")
    private Wypozyczenie wypozyczenie;

}
