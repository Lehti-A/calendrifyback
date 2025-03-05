package eu.calendrify.calendrifyback.controller.mood;

import eu.calendrify.calendrifyback.controller.mood.dto.MoodInfo;
import eu.calendrify.calendrifyback.controller.mood.dto.NewMood;
import eu.calendrify.calendrifyback.service.mood.MoodService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MoodController {

    private final MoodService moodService;
//todo: lisab uue rea, aga ei muuuda olemasolevat
    @PostMapping("/mood")
    @Operation(summary = "Uuendab Moodi andmeid")
    public void addNewMood(@RequestBody NewMood newMood) {
        moodService.addNewMood(newMood);
    }


    @GetMapping("/mood")
    @Operation(summary = "Tagastab Mood andmed")
    public List<MoodInfo> findMoodInfos(@RequestParam Integer dayId) {
        List<MoodInfo> moodInfos = moodService.findMoodInfos(dayId);
        return moodInfos;
    }

    @DeleteMapping("/mood")
    @Operation(summary = "Kustutab Mood andmed")
    public void deleteMood(@RequestParam Integer moodId) {
        moodService.deleteMood(moodId);
    }


}
