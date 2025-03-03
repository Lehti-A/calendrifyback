package eu.calendrify.calendrifyback.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "general_goal_template", schema = "calendrify")
public class GeneralGoalTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "general_goal_template_id_gen")
    @SequenceGenerator(name = "general_goal_template_id_gen", sequenceName = "general_goal_template_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "topic", nullable = false)
    private String topic;

}