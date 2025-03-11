package eu.calendrify.calendrifyback.controller.step;

import eu.calendrify.calendrifyback.controller.mood.dto.MoodInfo;
import eu.calendrify.calendrifyback.controller.step.dto.StepInfo;
import eu.calendrify.calendrifyback.service.step.StepService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
public class StepController {

    private final StepService stepService;

    @GetMapping("/step")
    @Operation(summary = "Toob Stepi andmed andmebaasist")
    public StepInfo findStepInfo(@RequestParam Integer userId, @RequestParam LocalDate date) {
        return stepService.findStepInfo(userId, date);
    }

    @PatchMapping("/step")
    @Operation(summary = "Uuendab Step andmeid")
    public void updateStep(@RequestParam Integer stepId, @RequestParam Integer count) {
        stepService.updateStep(stepId, count);
    }
}
