package eu.calendrify.calendrifyback.controller.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayExistenceInfo;
import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateDay;
import eu.calendrify.calendrifyback.service.day.DayService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor

public class DayController {

    private final DayService dayService;

    @PostMapping("/day")
    @Operation(summary = "Lisab andmebaasi andmeid")
    public void addNewDay(@RequestBody NewDay newDay) {
        dayService.addNewDay(newDay);
    }

    @GetMapping("/day")
    @Operation(summary = "Toob andmebaasist day andmed ära")
    public DayInfo findDayInfo(@RequestParam Integer dayId) {
        DayInfo dayInfo = dayService.findDayInfo(dayId);
        return dayInfo;
    }

    @GetMapping("/day-existence-info")
    public void getDayExistenceInfo(@RequestParam Integer userId, @RequestParam LocalDate date, @RequestParam String type) {
        dayService.getDayExistenceInfo(userId, date, type);
    }

    @PatchMapping("/day")
    @Operation(summary = "Uuendab day andmeid")
    public void updateDay(@RequestBody UpdateDay updateDay) {
        dayService.updateDay(updateDay);
    }


}
