package eu.calendrify.calendrifyback.controller.water;

import eu.calendrify.calendrifyback.controller.water.dto.WaterInfo;
import eu.calendrify.calendrifyback.service.water.WaterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class WaterController {

    private final WaterService waterService;

    @GetMapping("/water")
    @Operation(summary = "Toob Water andmed andmebaasist")
    public WaterInfo findWaterInfo(@RequestParam Integer userId, @RequestParam LocalDate date) {
        return waterService.findWaterInfo(userId, date);
    }

    @PatchMapping("/water")
    @Operation(summary = "Uuendab Water andmeid")
    public void updateWater(@RequestParam Integer waterId, @RequestParam Integer count) {
        waterService.updateWater(waterId, count);
    }
}