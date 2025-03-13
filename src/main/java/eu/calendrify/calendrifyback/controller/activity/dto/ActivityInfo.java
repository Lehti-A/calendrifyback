package eu.calendrify.calendrifyback.controller.activity.dto;

import eu.calendrify.calendrifyback.persistence.activity.Activity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Activity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInfo implements Serializable {

    @NotNull
    private Integer activityId;
    @NotNull
    @Size(max = 255)
    private String topic;
    @NotNull
    private Boolean isDone = false;
}