package eu.calendrify.calendrifyback.persistence.profile;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {
    Profile toEntity(NewUser newUser);

    NewUser toDto(Profile profile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Profile partialUpdate(NewUser newUser, @MappingTarget Profile profile);

    Profile toProfile(NewUser newUser);
}