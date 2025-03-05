package eu.calendrify.calendrifyback.persistence.mood;

import eu.calendrify.calendrifyback.controller.meeting.dto.MeetingInfo;
import eu.calendrify.calendrifyback.controller.mood.dto.MoodInfo;
import eu.calendrify.calendrifyback.controller.mood.dto.NewMood;
import eu.calendrify.calendrifyback.persistence.meeting.Meeting;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MoodMapper {


    @Mapping(source = "state", target = "state")
    MoodInfo toMoodInfo(Mood mood);

    List<MoodInfo> toMoodInfos (List <Mood> moods);

    @Mapping(source = "state", target = "state")
    Mood toMood(NewMood newMood);
}