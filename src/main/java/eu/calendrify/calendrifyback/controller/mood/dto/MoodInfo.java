package eu.calendrify.calendrifyback.controller.mood.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link eu.calendrify.calendrifyback.persistence.mood.Mood}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoodInfo implements Serializable {

    @NotNull
    @Size(max = 1)
    private String state;
}