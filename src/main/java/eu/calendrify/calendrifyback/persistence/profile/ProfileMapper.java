package eu.calendrify.calendrifyback.persistence.profile;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "termsAgreed", target = "termsAgreed")
    Profile toProfile(NewUser newUser);
}