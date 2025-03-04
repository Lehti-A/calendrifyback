package eu.calendrify.calendrifyback.controller.login;

import eu.calendrify.calendrifyback.controller.login.dto.LoginResponse;
import eu.calendrify.calendrifyback.infrastructure.error.ApiError;
import eu.calendrify.calendrifyback.service.login.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    @Operation(summary = "Sisse logimine. Tagastab userId ja roleName",
            description = """
                    Süsteemist otsitakse email ja password abil kasutajat, kelle konto on ka aktiivne.
                    Kui vastet ei leita vistakse viga errorCode'ga 111""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Vale kasutaja email või parool", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public LoginResponse login(@RequestParam String email, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(email, password);
        return loginResponse;
    }
}
