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

    public void addNewMeeting(NewMeeting newMeeting) {
        createAndSaveMeeting(newMeeting);
    }

    public List<MeetingInfo> findMeetingInfos(Integer dayId) {
        List<Meeting> meetings = getMeetingListBy(dayId);
        return meetingMapper.toMeetingInfos(meetings);
    }

    public void deleteMeeting(Integer meetingId) {
        getAndDeleteMeeting(meetingId);
    }

    private void createAndSaveMeeting(NewMeeting newMeeting) {
        Meeting meeting = createMeeting(newMeeting);
        meetingRepository.save(meeting);
    }

    private Meeting createMeeting(NewMeeting newMeeting) {
        Day day = dayRepository.getReferenceById(newMeeting.getDayId());
        Meeting meeting = meetingMapper.toMeeting(newMeeting);
        meeting.setDay(day);
        return meeting;
    }

    private List<Meeting> getMeetingListBy(Integer dayId) {
        return meetingRepository.findMeetingBy(dayId);
    }

    private void getAndDeleteMeeting(Integer meetingId) {
        Meeting meeting = getMeetingBy(meetingId);
        meetingRepository.delete(meeting);
    }

    private Meeting getMeetingBy(Integer meetingId) {
        return meetingRepository.getReferenceById(meetingId);
    }
}
