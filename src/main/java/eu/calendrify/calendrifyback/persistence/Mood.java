package eu.calendrify.calendrifyback.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mood", schema = "calendrify")
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mood_id_gen")
    @SequenceGenerator(name = "mood_id_gen", sequenceName = "mood_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    @Size(max = 1)
    @NotNull
    @Column(name = "state", nullable = false, length = 1)
    private String state;

}