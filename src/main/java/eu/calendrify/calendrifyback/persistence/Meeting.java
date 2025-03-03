package eu.calendrify.calendrifyback.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "meeting", schema = "calendrify")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meeting_id_gen")
    @SequenceGenerator(name = "meeting_id_gen", sequenceName = "meeting_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    @NotNull
    @Column(name = "\"time\"", nullable = false)
    private LocalTime time;

    @Size(max = 255)
    @NotNull
    @Column(name = "subject", nullable = false)
    private String subject;

}