package eu.calendrify.calendrifyback.controller.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.controller.focus.dto.NewFocus;
import eu.calendrify.calendrifyback.service.focus.FocusService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FocusController {
    private final FocusService focusService;

    @PostMapping("/focus")
    @Operation(summary = "Lisab uue Focus-e")
    public void addNewFocus(@RequestBody NewFocus newFocus) {
        focusService.addNewFocus(newFocus);
    }

    @GetMapping("/focuses")
    @Operation(summary = "Tagastab Focus listi andmed")
    public List<FocusInfo> findFocusInfos(@RequestParam Integer userId, @RequestParam Integer monthNumber, @RequestParam Integer year, @RequestParam String type) {
        List<FocusInfo> focusInfos = focusService.findFocusInfos(userId, monthNumber, year, type);
        return focusInfos;
    }

    @DeleteMapping("/focus")
    @Operation(summary = "Kustutab Focus-e")
    public void deleteFocus(@RequestParam Integer focusId) {
        focusService.deleteFocus(focusId);
    }


}


