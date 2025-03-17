package eu.calendrify.calendrifyback.controller.meeting.dto;

import eu.calendrify.calendrifyback.persistence.meeting.Meeting;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Meeting}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMeeting implements Serializable {
    @NotNull
    private Integer dayId;
    @NotNull
    private String time;
    @NotNull
    @Size(max = 255)
    private String subject;
}