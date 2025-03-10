package eu.calendrify.calendrifyback.service.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.controller.focus.dto.NewFocus;
import eu.calendrify.calendrifyback.persistence.focus.Focus;
import eu.calendrify.calendrifyback.persistence.focus.FocusMapper;
import eu.calendrify.calendrifyback.persistence.focus.FocusRepository;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FocusService {

    private final UserRepository userRepository;
    private final FocusRepository focusRepository;
    private final FocusMapper focusMapper;


    public void addNewFocus(NewFocus newFocus) {
        createAndSaveFocus(newFocus);
    }

    public List<FocusInfo> findFocusInfos(Integer userId, Integer monthNumber, Integer year, String type) {
        List<Focus> focuses = getFocusListBy(userId, monthNumber, year, type);
        return focusMapper.toFocusInfos(focuses);
    }

    public void updateFocusStatus(Integer focusId, Boolean isSelected) {
        Focus focus = getFocusById(focusId);
        updateAndSaveFocusStatus(isSelected, focus);
    }

    public void deleteFocus(Integer focusId) {
        getAndDeleteFocus(focusId);
    }

    private void createAndSaveFocus(NewFocus newFocus) {
        Focus focus = createFocus(newFocus);
        focusRepository.save(focus);
    }

    private Focus createFocus(NewFocus newFocus) {
        User user = getUserById(newFocus);
        Focus focus = getFocus(newFocus);
        focus.setUser(user);
        return focus;
    }

    private User getUserById(NewFocus newFocus) {
        return userRepository.getReferenceById(newFocus.getUserId());
    }

    private Focus getFocus(NewFocus newFocus) {
        return focusMapper.toFocus(newFocus);
    }

    private List<Focus> getFocusListBy(Integer userId, Integer monthNumber, Integer year, String type) {
        return focusRepository.findFocusBy(userId, monthNumber, year, type);
    }

    private Focus getFocusById(Integer focusId) {
        return focusRepository.getReferenceById(focusId);
    }

    private void updateAndSaveFocusStatus(Boolean isSelected, Focus focus) {
        focus.setIsSelected(isSelected);
        focusRepository.save(focus);
    }

    private void getAndDeleteFocus(Integer focusId) {
        Focus focus = getFocusById(focusId);
        focusRepository.delete(focus);
    }
}