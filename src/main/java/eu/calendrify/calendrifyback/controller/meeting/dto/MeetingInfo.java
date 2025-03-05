package eu.calendrify.calendrifyback.controller.meeting.dto;

import eu.calendrify.calendrifyback.persistence.meeting.Meeting;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link Meeting}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingInfo implements Serializable {
    @NotNull
    private LocalTime time;
    @NotNull
    @Size(max = 255)
    private String subject;
}