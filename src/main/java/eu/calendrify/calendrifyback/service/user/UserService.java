package eu.calendrify.calendrifyback.service.user;

import eu.calendrify.calendrifyback.controller.user.dto.NewUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUser;
import eu.calendrify.calendrifyback.controller.user.dto.UpdateUserPassword;
import eu.calendrify.calendrifyback.controller.user.dto.UserInfo;
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

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;
import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;
import static eu.calendrify.calendrifyback.status.Status.DELETED;

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
        // todo: otsi general_goal_template kõik read (mõtle ka järjestusele)
        // todo: lood uue tühja listi personal_goal_template entity-test
        // todo: teha for tsükkel general_goal_template ridadega
        // todo: igal tsüklil lood uue personal_goal_template objekti
        // todo: paned setteriga vajaliku info külge
        // todo: ja lisad personal_goal_template entity-te listi
        // todo: pärast for tsüklit salvesatd kõik personal_goal_template read saveAll() meetodiga

    }

    public UserInfo findUserInfos(Integer userId) {
        UserInfo userInfo = getAndSetUserInfoEmailBy(userId);
        Profile profile = getProfileBy(userId);
        userInfo.setAddress(profile.getAddress());
        userInfo.setPhone(profile.getPhone());
        return userInfo;
    }

    @Transactional
    public void updateUserProfile(UpdateUser updateUser, Integer userId) {
        updateAndSaveUser(updateUser, userId);
        updateAndSaveProfile(updateUser, userId);
    }

    public void updateUserPassword(@Valid UpdateUserPassword updateUserPassword) {
        User user = getUserById(updateUserPassword);
        updateAndSavePassword(updateUserPassword, user);
    }

    public void removeUser(Integer userId) {
        User user = getUserBy(userId);
        removeAndSaveUser(user);
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

    private UserInfo getAndSetUserInfoEmailBy(Integer userId) {
        User user = getUserBy(userId);
        if (user == null) {
            throw new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode());
        }
        return userMapper.touserInfo(user);
    }

    private User getUserBy(Integer userId) {
        return userRepository.findUserById(userId);
    }

    private Profile getProfileBy(Integer userId) {
        return profileRepository.findProfileBy(userId).orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
    }

    private void updateAndSaveUser(UpdateUser updateUser, Integer userId) {
        User user = getUserBy(userId);
        user.setEmail(updateUser.getEmail());
        userRepository.save(user);
    }

    private void updateAndSaveProfile(UpdateUser updateUser, Integer userId) {
        Profile profile = getProfileBy(userId);
        profile.setAddress(updateUser.getAddress());
        profile.setPhone(updateUser.getPhone());
        profileRepository.save(profile);
    }

    private User getUserById(UpdateUserPassword updateUserPassword) {
        return userRepository.findUserById(updateUserPassword.getId());
    }

    private void updateAndSavePassword(UpdateUserPassword updateUserPassword, User user) {
        user.setPassword(updateUserPassword.getPassword());
        userRepository.save(user);
    }

    private void removeAndSaveUser(User user) {
        user.setStatus(DELETED.getCode());
        userRepository.save(user);
    }
}