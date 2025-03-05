package eu.calendrify.calendrifyback.controller.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.infrastructure.error.ApiError;
import eu.calendrify.calendrifyback.service.focus.FocusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FocusController {
    private final FocusService focusService;

    @GetMapping("/calendar")
    @Operation(summary = "Tagastab Focus listi andmed")
    public List <FocusInfo> findFocusInfos(@RequestParam Integer userId, @RequestParam Integer monthNumber, @RequestParam Integer year, @RequestParam String type) {
        List <FocusInfo> focusInfos = focusService.findFocusInfos(userId, monthNumber, year, type);
        return focusInfos;
    }
}


