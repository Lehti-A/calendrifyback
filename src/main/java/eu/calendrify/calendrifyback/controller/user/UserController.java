package eu.calendrify.calendrifyback.controller.user;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUserPassword;
import eu.calendrify.calendrifyback.controller.user.dto.UserInfo;
import eu.calendrify.calendrifyback.infrastructure.error.ApiError;
import eu.calendrify.calendrifyback.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Uue kasutaja lisamine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "409", description = "Entered email is already in use (errorCode 880)", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addNewUser(@RequestBody @Valid NewUser newUser) {
        userService.addNewUser(newUser);
    }

    @GetMapping("/settings-user")
    @Operation(summary = "Toob ära kasutaja info")
    public UserInfo findUserInfos(@RequestParam Integer userId) {
        return userService.findUserInfos(userId);
    }

    @PatchMapping("/settings-user")
    @Operation(summary = "Uuendab kasutaja andmeid")
    public void updateUserProfile(@RequestBody @Valid UpdateUser updateUser, @RequestParam Integer userId) {
        userService.updateUserProfile(updateUser, userId);
    }

    @PatchMapping("/settings-password")
    @Operation(summary = "Uuendab kasutaja parooli")
    public void updateUserPassword(@RequestBody @Valid UpdateUserPassword updateUserPassword, @RequestParam Integer userId) {
        userService.updateUserPassword(updateUserPassword, userId);
    }

    @DeleteMapping("/settings-user")
    @Operation(summary = "Eemaldab useri userId abil",
            description = "Tabelitest ühtegi kirjet ei eemaldata, 'user' tabelis muudetakse status väärtus D-ks ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Primary key not found (errorCode 888)", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void removeUser(@RequestParam Integer userId) {
        userService.removeUser(userId);
    }
}