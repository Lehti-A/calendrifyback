package eu.calendrify.calendrifyback.persistence.meeting;

import eu.calendrify.calendrifyback.controller.meeting.dto.MeetingInfo;
import eu.calendrify.calendrifyback.controller.meeting.dto.NewMeeting;
import org.mapstruct.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeetingMapper {

    @Mapping(source = "id", target = "meetingId")
    @Mapping(source = "time", target = "time")
    @Mapping(source = "subject", target = "subject")
    MeetingInfo toMeetingInfo(Meeting meeting);

    List<MeetingInfo> toMeetingInfos(List<Meeting> meetings);

    @Mapping(source = "time", target = "time", qualifiedByName = "toLocalTime")
    @Mapping(source = "subject", target = "subject")
    Meeting toMeeting(NewMeeting newMeeting);

    @Named("toLocalTime")
    static LocalTime toLocalTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }

}