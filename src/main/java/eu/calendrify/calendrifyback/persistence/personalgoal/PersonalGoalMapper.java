package eu.calendrify.calendrifyback.persistence.personalgoal;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonalGoalMapper {

    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "isDone", target = "isDone")
    PersonalGoalInfo toPersonalGoalInfo(PersonalGoal personalGoal);
    List<PersonalGoalInfo> toPersonalGoalInfos (List<PersonalGoal> personalGoals);

}