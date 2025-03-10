package eu.calendrify.calendrifyback.persistence.meeting;

import eu.calendrify.calendrifyback.controller.meeting.dto.MeetingInfo;
import eu.calendrify.calendrifyback.controller.meeting.dto.NewMeeting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeetingMapper {

    @Mapping(source = "time", target = "time")
    @Mapping(source = "subject", target = "subject")
    MeetingInfo toMeetingInfo(Meeting meeting);

    List<MeetingInfo> toMeetingInfos(List<Meeting> meetings);


    @Mapping(source = "time", target = "time")
    @Mapping(source = "subject", target = "subject")
    Meeting toMeeting(NewMeeting newMeeting);

}