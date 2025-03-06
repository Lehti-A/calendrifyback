package eu.calendrify.calendrifyback.controller.personalgoal.dto;

import eu.calendrify.calendrifyback.persistence.personalgoaltemplate.PersonalGoalTemplate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link PersonalGoalTemplate}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalGoalTemplateInfo implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String topic;
}