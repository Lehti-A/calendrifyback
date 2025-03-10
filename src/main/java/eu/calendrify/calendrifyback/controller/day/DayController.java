package eu.calendrify.calendrifyback.controller.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateFocusDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateThoughtDay;
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
    @Operation(summary = "Lisab andmebaasi day andmed")
    public void addNewDay(@RequestBody NewDay newDay) {
        dayService.addNewDay(newDay);
    }

    @GetMapping("/day")
    @Operation(summary = "Toob andmebaasist day andmed")
    public DayInfo findDayInfo(@RequestParam Integer dayId) {
        return dayService.findDayInfo(dayId);
    }

    @GetMapping("/day-existence-info")
    @Operation(summary = "Vaatab, kas andmebaasis on loodud valitud day kanne",
            description = "Kui andmebaasis ei ole day kannet, siis süsteem loob selle. Kui andmebaasis on day kanne olemas, siis toob day andmed ära andmebaasist.")
    public void getDayExistenceInfo(@RequestParam Integer userId, @RequestParam LocalDate date, @RequestParam String type) {
        dayService.getDayExistenceInfo(userId, date, type);
    }

    @PatchMapping("/day-focus")
    @Operation(summary = "Uuendab day focus andmeid")
    public void updateDay(@RequestBody UpdateFocusDay updateFocusDay) {
        dayService.updateFocusDay(updateFocusDay);
    }

    @PatchMapping("/day-thought")
    @Operation(summary = "Uuendab day thought andmeid")
    public void updateDay(@RequestBody UpdateThoughtDay updateThoughtDay) {
        dayService.updateThoughtDay(updateThoughtDay);
    }
}