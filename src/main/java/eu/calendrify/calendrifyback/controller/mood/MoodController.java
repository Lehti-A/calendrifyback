package eu.calendrify.calendrifyback.controller.mood;

import eu.calendrify.calendrifyback.service.mood.MoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoodController {

    private final MoodService moodService;

    @PatchMapping("/mood")
    @Operation(summary = "Uuendab Moodi andmeid")
    public void updateMood(@RequestParam Integer moodId, @RequestParam String state) {
        moodService.updateMood(moodId, state);
    }
}