package eu.calendrify.calendrifyback.service.meeting;

import eu.calendrify.calendrifyback.controller.meeting.dto.MeetingInfo;
import eu.calendrify.calendrifyback.controller.meeting.dto.NewMeeting;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.meeting.Meeting;
import eu.calendrify.calendrifyback.persistence.meeting.MeetingMapper;
import eu.calendrify.calendrifyback.persistence.meeting.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final DayRepository dayRepository;
    private final MeetingRepository meetingRepository;
    private final MeetingMapper meetingMapper;


    public List<MeetingInfo> findMeetingInfos(Integer dayId) {
        List<Meeting> meetings = meetingRepository.findMeetingBy(dayId);
        List<MeetingInfo> meetingInfos = meetingMapper.toMeetingInfos(meetings);
        return meetingInfos;

    }

    public void addNewMeeting(NewMeeting newMeeting) {
        Meeting meeting = createNewMeeting(newMeeting);
        meetingRepository.save(meeting);
    }

    public void deleteMeeting(Integer meetingId) {
        Meeting meeting = meetingRepository.getReferenceById(meetingId);
        meetingRepository.delete(meeting);
    }

    private Meeting createNewMeeting(NewMeeting newMeeting) {
        Day day = dayRepository.getReferenceById(newMeeting.getDayId());
        Meeting meeting = meetingMapper.toMeeting(newMeeting);
        meeting.setDay(day);
        return meeting;
    }
}
