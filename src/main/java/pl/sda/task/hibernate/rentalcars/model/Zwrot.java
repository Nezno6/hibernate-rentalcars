package pl.sda.task.hibernate.rentalcars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Builder
@Table(name = "zwrot")
@NoArgsConstructor
@AllArgsConstructor
public class Zwrot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;

    @CreationTimestamp
    @Column(name = "data_zwrotu")
    private LocalDate dataZwrotu;
    @Column(name = "godzina_zwrotu")
    private LocalTime godzinaZwrotu;
    private String notatka;

    @OneToOne
    @JoinColumn(name = "wypozyczenie_id", referencedColumnName = "id")
    private Wypozyczenie wypozyczenie;

}
