package eu.calendrify.calendrifyback.service.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateDay;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayMapper;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DayService {

    private final UserRepository userRepository;
    private final DayRepository dayRepository;
    private final DayMapper dayMapper;


    public void addNewDay(NewDay newDay) {
        Day day = createDay(newDay);
        dayRepository.save(day);
    }

    public DayInfo findDayInfo(Integer dayId) {
        Day day = dayRepository.findById(dayId).orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        DayInfo dayInfo = dayMapper.toDayInfo(day);
        return dayInfo;
    }

    private Day createDay(NewDay newDay) {
        User user = userRepository.getReferenceById(newDay.getUserId());
        Day day = dayMapper.toDay(newDay);
        day.setUser(user);
        return day;
    }

    public void updateDay(UpdateDay updateDay) {
        Day day = dayRepository.getReferenceById(updateDay.getId());
        day.setType(updateDay.getType());
        day.setFocus(updateDay.getFocus());
        day.setThoughts(updateDay.getThoughts());
        dayRepository.save(day);

    }
}
