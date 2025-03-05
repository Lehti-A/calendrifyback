package eu.calendrify.calendrifyback.service.focus;

import eu.calendrify.calendrifyback.controller.focus.dto.FocusInfo;
import eu.calendrify.calendrifyback.persistence.focus.Focus;
import eu.calendrify.calendrifyback.persistence.focus.FocusMapper;
import eu.calendrify.calendrifyback.persistence.focus.FocusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FocusService {

    private final FocusRepository focusRepository;
    private final FocusMapper focusMapper;


    public List <FocusInfo> findFocusInfos(Integer userId, Integer monthNumber, Integer year, String type) {
        List <Focus> focuses = focusRepository.findFocusBy(userId, monthNumber, year, type);
        List <FocusInfo> focusInfos = focusMapper.toFocusInfos(focuses);


        //todo:.orElseThrow(() -> ValidationService.throwForeignKeyNotFoundException("userId", userId));
        return focusInfos;

    }


}
