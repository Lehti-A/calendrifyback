package eu.calendrify.calendrifyback.persistence.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DayMapper {

    @Mapping(source = "date", target = "date")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "focus", target = "focus")
    @Mapping(source = "thoughts", target = "thoughts")
    Day toDay(NewDay newDay);

    DayInfo toDayInfo(Day day);

}