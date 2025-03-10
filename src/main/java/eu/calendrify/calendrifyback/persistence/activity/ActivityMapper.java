package eu.calendrify.calendrifyback.persistence.activity;

import eu.calendrify.calendrifyback.controller.activity.dto.ActivityInfo;
import eu.calendrify.calendrifyback.controller.activity.dto.NewActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {

    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "isDone", target = "isDone")
    ActivityInfo toActivityInfo(Activity activity);

    List<ActivityInfo> toActivityInfos(List<Activity> activities);

    @Mapping(source = "topic", target = "topic")
    Activity toActivity(NewActivity newActivity);
}