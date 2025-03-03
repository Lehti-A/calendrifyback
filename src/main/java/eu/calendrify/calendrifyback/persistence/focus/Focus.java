package eu.calendrify.calendrifyback.persistence.focus;

import eu.calendrify.calendrifyback.persistence.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "focus", schema = "calendrify")
public class Focus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "topic", nullable = false)
    private String topic;

    @NotNull
    @Column(name = "is_selected", nullable = false)
    private Boolean isSelected = false;

    @NotNull
    @Column(name = "month_number", nullable = false)
    private Integer monthNumber;

    @NotNull
    @Column(name = "year", nullable = false)
    private Integer year;

    @Size(max = 1)
    @NotNull
    @Column(name = "type", nullable = false, length = 1)
    private String type;

}