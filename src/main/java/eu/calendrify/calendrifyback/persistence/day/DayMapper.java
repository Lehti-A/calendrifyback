package eu.calendrify.calendrifyback.persistence.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import org.mapstruct.*;

import java.time.LocalDate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DayMapper {

    @Mapping(source = "date", target = "date")
    @Mapping(source = "type", target = "type")
    @Mapping(constant = "", target = "focus")
    @Mapping(constant = "", target = "thoughts")
    Day toDay(NewDay newDay);

    @Mapping(source = "id", target = "dayId")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "focus", target = "focus")
    @Mapping(source = "thoughts", target = "thoughts")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "date", target = "monthName", qualifiedByName = "toMonthName")
    @Mapping(source = "date", target = "dayNumber", qualifiedByName = "toDayNumber")
    @Mapping(source = "date", target = "weekDay", qualifiedByName = "toWeekDay")
    DayInfo toDayInfo(Day day);

    @Named("toMonthName")
    static String toMonthName(LocalDate date) {
        return date.getMonth().name();
    }

    @Named("toDayNumber")
    static Integer toDayNumber(LocalDate date) {
        return date.getDayOfMonth();
    }

    @Named("toWeekDay")
    static String toWeekDay(LocalDate date) {
        return date.getDayOfWeek().name();
    }
}