package eu.calendrify.calendrifyback.controller.mood.dto;

import eu.calendrify.calendrifyback.persistence.mood.Mood;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Mood}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoodInfo implements Serializable {
    @NotNull
    private Integer moodId;

    @NotNull
    @Size(max = 1)
    private String state;

}