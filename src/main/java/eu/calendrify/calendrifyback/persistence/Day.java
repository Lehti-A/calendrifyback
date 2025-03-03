package eu.calendrify.calendrifyback.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "day", schema = "calendrify")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "day_id_gen")
    @SequenceGenerator(name = "day_id_gen", sequenceName = "day_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Size(max = 1)
    @NotNull
    @Column(name = "type", nullable = false, length = 1)
    private String type;

    @Size(max = 255)
    @NotNull
    @Column(name = "focus", nullable = false)
    private String focus;

    @Size(max = 1000)
    @NotNull
    @Column(name = "thoughts", nullable = false, length = 1000)
    private String thoughts;

}