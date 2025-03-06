package eu.calendrify.calendrifyback.service.user;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUser;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.profile.Profile;
import eu.calendrify.calendrifyback.persistence.profile.ProfileMapper;
import eu.calendrify.calendrifyback.persistence.profile.ProfileRepository;
import eu.calendrify.calendrifyback.persistence.role.Role;
import eu.calendrify.calendrifyback.persistence.role.RoleRepository;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserMapper;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    public static final int ROLE_CUSTOMER = 2;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProfileRepository profileRepository;
    private final UserMapper userMapper;
    private final ProfileMapper profileMapper;

    @Transactional
    public void addNewUser(NewUser newUser) {
        User user = createAndSaveUser(newUser);
        createAndSaveProfile(newUser, user);
    }

    private User createAndSaveUser(NewUser newUser) {
        User user = createUser(newUser);
        userRepository.save(user);
        return user;
    }

    private User createUser(NewUser newUser) {
        Role role = roleRepository.getReferenceById(ROLE_CUSTOMER);
        User user = userMapper.toUser(newUser);
        user.setRole(role);
        return user;
    }

    private void createAndSaveProfile(NewUser newUser, User user) {
        Profile profile = createProfile(newUser, user);
        profileRepository.save(profile);
    }

    private Profile createProfile(NewUser newUser, User user) {
        Profile profile = profileMapper.toProfile(newUser);
        profile.setUser(user);
        return profile;
    }


    public void updateUserProfile(UpdateUser updateUser, Integer userId) {
        User user = updateAndSaveUser(updateUser, userId);
        updateAndSaveProfile(updateUser, user);
    }
// todo: teha updateUserProfile korda ja siis hiljem teha ka delete UserProfile

//    private User updateAndSaveUser(UpdateUser updateUser, Integer userId) {
//        User user = userRepository.findUserById(userId).orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
//
//        user.setEmail(updateUser.getEmail());
//        userRepository.save(user);
//        return user;
//    }
//    private void updateAndSaveProfile(UpdateUser updateUser, User user) {
//        Profile profile = profileRepository.findByUserId(user.getId());
//
//    }

}
