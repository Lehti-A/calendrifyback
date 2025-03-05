package eu.calendrify.calendrifyback.controller.activity;

import eu.calendrify.calendrifyback.controller.activity.dto.ActivityInfo;
import eu.calendrify.calendrifyback.controller.activity.dto.NewActivity;
import eu.calendrify.calendrifyback.service.activity.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityService activityService;

    @PostMapping("/activity")
    @Operation(summary = "Lisab uue Activity")
    public void addNewActivity(@RequestBody NewActivity newActivity) {
        activityService.addNewActivity(newActivity);
    }

    @GetMapping("/activity")
    @Operation(summary = "Tagastab Activity listi andmed")
    public List<ActivityInfo> findActivityInfos(@RequestParam Integer dayId) {
        List<ActivityInfo> activityInfos = activityService.findActivityInfos(dayId);
        return activityInfos;
    }

    @DeleteMapping("/activity")
    @Operation(summary = "Kustutab Activity")
    public void deleteActivity(@RequestParam Integer activityId) {
        activityService.deleteActivity(activityId);
    }


}
