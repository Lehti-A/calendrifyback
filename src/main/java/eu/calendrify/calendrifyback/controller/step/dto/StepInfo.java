package eu.calendrify.calendrifyback.controller.step.dto;

import eu.calendrify.calendrifyback.persistence.step.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Step}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepInfo implements Serializable {

    private Integer stepId;
    private Integer count;
}