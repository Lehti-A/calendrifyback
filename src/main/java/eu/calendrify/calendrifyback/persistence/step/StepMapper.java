package eu.calendrify.calendrifyback.persistence.step;

import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.step.dto.StepInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StepMapper {

    @Mapping(source = "date", target = "date")
    @Mapping(constant = "0", target = "count")
    Step toStep(NewDay newDay);


    @Mapping(source = "id", target = "stepId")
    @Mapping(source = "count", target = "count")
    StepInfo toStepInfo(Step step);

}