package eu.calendrify.calendrifyback.persistence.personalgoal;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.NewPersonalGoal;
import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonalGoalMapper {

    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "isDone", target = "isDone")
    PersonalGoalInfo toPersonalGoalInfo(PersonalGoal personalGoal);

    List<PersonalGoalInfo> toPersonalGoalInfos(List<PersonalGoal> personalGoals);

    @Mapping(source = "topic", target = "topic")
    @Mapping(constant = "false", target = "isDone")
    PersonalGoal toPersonalGoal(NewPersonalGoal newPersonalGoal);
}