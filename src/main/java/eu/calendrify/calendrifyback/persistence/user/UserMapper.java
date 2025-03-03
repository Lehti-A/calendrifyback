package eu.calendrify.calendrifyback.persistence.user;

import eu.calendrify.calendrifyback.controller.login.dto.LoginResponse;
import eu.calendrify.calendrifyback.status.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {Status.class})
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role" , target = "roleName")
    LoginResponse toLoginResponse(User user);

//    @Mapping(source = "username", target = "username")
//    @Mapping(source = "password", target = "password")
//    @Mapping(expression = "java(Status.ACTIVE.getCode())", target = "status")
//    User toUser(NewUser newUser);

}