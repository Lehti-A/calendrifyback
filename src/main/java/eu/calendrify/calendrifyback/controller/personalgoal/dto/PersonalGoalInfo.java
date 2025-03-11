package eu.calendrify.calendrifyback.controller.personalgoal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link eu.calendrify.calendrifyback.persistence.personalgoal.PersonalGoal}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalGoalInfo implements Serializable {
    @NotNull
    private Integer id;
    @NotNull
    private Integer dayId;
    @NotNull
    @Size(max = 255)
    private String topic;
    @NotNull
    private Boolean isDone = false;
}