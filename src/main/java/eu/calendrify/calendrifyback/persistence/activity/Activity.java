package eu.calendrify.calendrifyback.persistence.activity;

import eu.calendrify.calendrifyback.persistence.Day;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activity", schema = "calendrify")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    @Size(max = 255)
    @NotNull
    @Column(name = "topic", nullable = false)
    private String topic;

    @NotNull
    @Column(name = "is_done", nullable = false)
    private Boolean isDone = false;

}