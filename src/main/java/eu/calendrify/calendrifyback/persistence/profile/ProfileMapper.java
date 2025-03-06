package eu.calendrify.calendrifyback.persistence.profile;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUser;
import eu.calendrify.calendrifyback.persistence.user.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "termsAgreed", target = "termsAgreed")

    Profile toProfile(NewUser newUser);


    @Mapping(source = "address", target = "address")
    @Mapping(source = "phone", target = "phone")
    void updateProfileFromUpdateUser(@MappingTarget Profile profile, UpdateUser updateUser);





}