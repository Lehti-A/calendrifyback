package eu.calendrify.calendrifyback.controller.day.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//todo:kustutada see
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayExistenceInfo {
    private Boolean personalDayExists;
    private Integer personalDayId;
    private Boolean workDayExists;
    private Integer workDayId;
}
