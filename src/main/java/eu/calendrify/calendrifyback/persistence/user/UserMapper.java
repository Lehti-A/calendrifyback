package eu.calendrify.calendrifyback.persistence.user;

import eu.calendrify.calendrifyback.controller.login.dto.LoginResponse;
import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import eu.calendrify.calendrifyback.controller.user.dto.UserInfo;
import eu.calendrify.calendrifyback.status.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "email", target = "email")
    UserInfo touserInfo(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
    User toUser(NewUser newUser);

}