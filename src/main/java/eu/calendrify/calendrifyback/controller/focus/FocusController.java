package eu.calendrify.calendrifyback.controller.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.persistence.focus.NewFocus;
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
    public void addNewFocus(@RequestBody NewFocus newFocus) {
        focusService.addNewFocus(newFocus);
    }

    @GetMapping("/focus")
    @Operation(summary = "Tagastab Focus listi andmed")
    public List<FocusInfo> findFocusInfos(@RequestParam Integer userId, @RequestParam Integer monthNumber, @RequestParam Integer year, @RequestParam String type) {
        List<FocusInfo> focusInfos = focusService.findFocusInfos(userId, monthNumber, year, type);
        return focusInfos;
    }


}


