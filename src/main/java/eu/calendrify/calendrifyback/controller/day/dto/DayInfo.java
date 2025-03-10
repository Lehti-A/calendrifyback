package eu.calendrify.calendrifyback.controller.day.dto;

import eu.calendrify.calendrifyback.persistence.day.Day;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Day}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayInfo implements Serializable {
    @NotNull
    @Size(max = 1)
    private String type;
    @NotNull
    @Size(max = 255)
    private String focus;
    @NotNull
    @Size(max = 1000)
    private String thoughts;
    private LocalDate date;
    private String monthName;
    private Integer dayNumber;
    private String weekDay;

}