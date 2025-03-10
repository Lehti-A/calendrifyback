package eu.calendrify.calendrifyback.controller.meeting;

import eu.calendrify.calendrifyback.controller.meeting.dto.MeetingInfo;
import eu.calendrify.calendrifyback.controller.meeting.dto.NewMeeting;
import eu.calendrify.calendrifyback.service.meeting.MeetingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;

    //todo: postMapping ei tööta Swaggeris.

    @PostMapping("/meeting")
    @Operation(summary = "Lisab uue Meetingu")
    public void addNewMeeting(@RequestBody NewMeeting newMeeting) {
        meetingService.addNewMeeting(newMeeting);
    }

    @GetMapping("/meeting")
    @Operation(summary = "Tagastab Meeting listi andmed")
    public List<MeetingInfo> findMeetingInfos(@RequestParam Integer dayId) {
        return meetingService.findMeetingInfos(dayId);
    }

    @DeleteMapping("/meeting")
    @Operation(summary = "Kustutab Meetingu")
    public void deleteMeeting(@RequestParam Integer meetingId) {
        meetingService.deleteMeeting(meetingId);
    }
}