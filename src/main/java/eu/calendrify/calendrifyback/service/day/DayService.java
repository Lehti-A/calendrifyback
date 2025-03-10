package eu.calendrify.calendrifyback.service.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateFocusDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateThoughtDay;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayMapper;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DayService {

    private final UserRepository userRepository;
    private final DayRepository dayRepository;
    private final DayMapper dayMapper;


    public void addNewDay(NewDay newDay) {
        boolean userExists = doesUserExists(newDay);
        if (!userExists) {
            createAndSaveDay(newDay);
        }
    }

    public void getDayExistenceInfo(Integer userId, LocalDate date, String type) {
        boolean dayExists = dayRepository.userExistsBy(userId, date, type);
        if (dayExists) {
            findDayInfo(dayRepository.findDayBy(userId, type, date));
        } else {
            NewDay newDay = new NewDay(userId, date, type, "", "");
            addNewDay(newDay);
        }
        // todo: reposirotrise uus meetod, leiab day: userId, date ja type abil. wrapid optionali sisse
        // todo: lood uue tühja  DayExistenceInfo objekti
        // todo: leiad ülesse personal Day objekti (rea)
        // todo: leiad ülesse work Day objekti (rea)
        // todo: täidad ära DayExistenceInfo info olemasoleva infoga
    }

    public DayInfo findDayInfo(Integer dayId) {
        Day day = getDayById(dayId);
        return dayMapper.toDayInfo(day);
    }

    public void updateFocusDay(UpdateFocusDay updateFocusDay) {
        Day day = getDayByUpdateFocusDayId(updateFocusDay);
        updateAndSaveFocus(updateFocusDay, day);
    }

    public void updateThoughtDay(UpdateThoughtDay updateThoughtDay) {
        Day day = getDayByUpdateThoughtDayId(updateThoughtDay);
        updateAndSaveThought(day, updateThoughtDay.getThoughts());
    }

    private boolean doesUserExists(NewDay newDay) {
        return dayRepository.userExistsBy(newDay.getUserId(), newDay.getDate(), newDay.getType());
    }

    private void createAndSaveDay(NewDay newDay) {
        Day day = createDay(newDay);
        dayRepository.save(day);
    }

    private Day createDay(NewDay newDay) {
        User user = userRepository.getReferenceById(newDay.getUserId());
        Day day = dayMapper.toDay(newDay);
        day.setUser(user);
        return day;
    }

    private Day getDayById(Integer dayId) {
        return dayRepository.findById(dayId).orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
    }

    private Day getDayByUpdateFocusDayId(UpdateFocusDay updateFocusDay) {
        return dayRepository.getReferenceById(updateFocusDay.getId());
    }

    private void updateAndSaveFocus(UpdateFocusDay updateFocusDay, Day day) {
        day.setFocus(updateFocusDay.getFocus());
        dayRepository.save(day);
    }

    private Day getDayByUpdateThoughtDayId(UpdateThoughtDay updateThoughtDay) {
        return dayRepository.getReferenceById(updateThoughtDay.getId());
    }

    private void updateAndSaveThought(Day day, String updateThoughtDay) {
        day.setThoughts(updateThoughtDay);
        dayRepository.save(day);
    }
}