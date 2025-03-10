package eu.calendrify.calendrifyback.service.login;

import eu.calendrify.calendrifyback.controller.login.dto.LoginResponse;
import eu.calendrify.calendrifyback.infrastructure.exception.ForbiddenException;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserMapper;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static eu.calendrify.calendrifyback.infrastructure.Error.INCORRECT_CREDENTIALS;
import static eu.calendrify.calendrifyback.status.Status.ACTIVE;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public LoginResponse login(String email, String password) {
        User user = getUserBy(email, password);
        return userMapper.toLoginResponse(user);
    }

    private User getUserBy(String email, String password) {
        return userRepository.findUserBy(email, password, ACTIVE.getCode()).orElseThrow(() -> new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode()));
    }
}