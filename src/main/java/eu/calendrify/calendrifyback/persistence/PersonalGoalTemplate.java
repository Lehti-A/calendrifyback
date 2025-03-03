package eu.calendrify.calendrifyback.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personal_goal_template", schema = "calendrify")
public class PersonalGoalTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personal_goal_template_id_gen")
    @SequenceGenerator(name = "personal_goal_template_id_gen", sequenceName = "personal_goal_template_id_seq", allocationSize = 1)
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

}