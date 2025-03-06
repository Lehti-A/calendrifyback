package eu.calendrify.calendrifyback.controller.step;

import eu.calendrify.calendrifyback.service.step.StepService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StepController {

    private final StepService stepService;

    @PatchMapping("/step")
    @Operation(summary = "Uuendab Step andmeid")
    public void updateStep(@RequestParam Integer stepId, @RequestParam Integer count) {
        stepService.updateStep(stepId, count);
    }

}
