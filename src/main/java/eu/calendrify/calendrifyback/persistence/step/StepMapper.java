package eu.calendrify.calendrifyback.persistence.step;

import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StepMapper {

    @Mapping(source = "date", target = "date")
    @Mapping(constant = "0", target = "count")
    Step toStep(NewDay newDay);

}