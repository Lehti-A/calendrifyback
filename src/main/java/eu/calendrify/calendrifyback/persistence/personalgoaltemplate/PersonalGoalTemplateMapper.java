package eu.calendrify.calendrifyback.persistence.personalgoaltemplate;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.NewPersonalGoalTemplate;
import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalTemplateInfo;
import eu.calendrify.calendrifyback.persistence.generalgoaltemplate.GeneralGoalTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonalGoalTemplateMapper {

    @Mapping(source = "topic", target = "topic")
    PersonalGoalTemplateInfo toPersonalGoalTemplateInfo(PersonalGoalTemplate personalGoalTemplate);

    List<PersonalGoalTemplateInfo> toPersonalGoalTemplateInfos(List<PersonalGoalTemplate> personalGoalTemplates);




    @Mapping(source = "topic", target = "topic")
    PersonalGoalTemplate toPersonalGoalTemplate(NewPersonalGoalTemplate newPersonalGoalTemplate);
    List<PersonalGoalTemplate> toPersonalGoalTemplates(List<GeneralGoalTemplate> newPersonalGoalTemplates);


    }