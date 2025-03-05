package eu.calendrify.calendrifyback.service.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.persistence.focus.Focus;
import eu.calendrify.calendrifyback.persistence.focus.FocusMapper;
import eu.calendrify.calendrifyback.persistence.focus.FocusRepository;
import eu.calendrify.calendrifyback.controller.focus.dto.NewFocus;
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


    public List <FocusInfo> findFocusInfos(Integer userId, Integer monthNumber, Integer year, String type) {
        List <Focus> focuses = focusRepository.findFocusBy(userId, monthNumber, year, type);
        List <FocusInfo> focusInfos = focusMapper.toFocusInfos(focuses);
        return focusInfos;
    }

    public void addNewFocus(NewFocus newFocus) {
        Focus focus = createFocus(newFocus);
        focusRepository.save(focus);
    }

    public void deleteFocus(Integer focusId) {
        Focus focus = focusRepository.getReferenceById(focusId);
        focusRepository.delete(focus);

    }

    private Focus createFocus(NewFocus newFocus) {
        User user = userRepository.getReferenceById(newFocus.getUserId());
        Focus focus = focusMapper.toFocus(newFocus);
        focus.setUser(user);
        return focus;
    }


}
