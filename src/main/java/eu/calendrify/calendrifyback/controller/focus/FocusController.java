package eu.calendrify.calendrifyback.controller.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.service.focus.FocusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FocusController {
    private final FocusService focusService;

    @GetMapping("/calendar")
    public FocusInfo focus(@RequestParam String dayId, @RequestBody @Valid FocusInfo focusInfo) {
        FocusInfo focusInfo = focusService;
        return focusInfo;
    }


