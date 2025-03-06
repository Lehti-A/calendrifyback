package eu.calendrify.calendrifyback.controller.user;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUser;
import eu.calendrify.calendrifyback.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Uue kasutaja lisamine")
    public void addNewUser(@RequestBody @Valid NewUser newUser) {
        userService.addNewUser(newUser);
    }

    @PatchMapping("/settings")
    @Operation(summary = "Uuendab kasutaja andmeid")
    public void updateUserProfile (@RequestBody @Valid UpdateUser updateUser, @RequestParam Integer userId) {
        userService.updateUserProfile(updateUser, userId);
    }
}
