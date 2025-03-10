package eu.calendrify.calendrifyback.service.day;

import eu.calendrify.calendrifyback.controller.day.dto.DayInfo;
import eu.calendrify.calendrifyback.controller.day.dto.NewDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateFocusDay;
import eu.calendrify.calendrifyback.controller.day.dto.UpdateThoughtDay;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayMapper;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.mood.Mood;
import eu.calendrify.calendrifyback.persistence.mood.MoodRepository;
import eu.calendrify.calendrifyback.persistence.step.Step;
import eu.calendrify.calendrifyback.persistence.step.StepMapper;
import eu.calendrify.calendrifyback.persistence.step.StepRepository;
import eu.calendrify.calendrifyback.persistence.user.User;
import eu.calendrify.calendrifyback.persistence.user.UserRepository;
import eu.calendrify.calendrifyback.persistence.water.Water;
import eu.calendrify.calendrifyback.persistence.water.WaterMapper;
import eu.calendrify.calendrifyback.persistence.water.WaterRepository;
import eu.calendrify.calendrifyback.status.MoodState;
import eu.calendrify.calendrifyback.status.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DayService {

    private final UserRepository userRepository;
    private final DayRepository dayRepository;
    private final DayMapper dayMapper;
    private final MoodRepository moodRepository;
    private final WaterRepository waterRepository;
    private final WaterMapper waterMapper;
    private final StepRepository stepRepository;
    private final StepMapper stepMapper;


    public DayInfo addNewDay(NewDay newDay) {
        Optional<Day> optionalDay = dayRepository.findDayBy(newDay.getUserId(), newDay.getType(), newDay.getDate());

        if (optionalDay.isPresent()) {
            Day day = optionalDay.get();
            return dayMapper.toDayInfo(day);
        }
        Day day = createAndSaveDay(newDay);
        User user = day.getUser();
        Mood mood = new Mood();
        mood.setDay(day);
        mood.setState(MoodState.UNSELECTED.getCode());
        moodRepository.save(mood);


        boolean waterExists = waterRepository.waterExistsBy(newDay.getUserId(), newDay.getDate());
        if (!waterExists) {
            Water water = waterMapper.toWater(newDay);
            water.setUser(user);
            waterRepository.save(water);
        }

        boolean stepsExists = stepRepository.stepsExistsBy(newDay.getUserId(), newDay.getDate());
        if (!stepsExists) {
            Step step = stepMapper.toStep(newDay);
            step.setUser(user);
            stepRepository.save(step);
        }

        // todo: teha see kui on useri alt tehtud goalide asi.

        if (Type.PERSONAL.getCode().equals(newDay.getType())) {

        }


    }

    private Day createAndSaveDay(NewDay newDay) {
        Day day = createDay(newDay);
        dayRepository.save(day);
        return day;
    }

    private Day createDay(NewDay newDay) {
        User user = userRepository.getReferenceById(newDay.getUserId());
        Day day = dayMapper.toDay(newDay);
        day.setUser(user);
        return day;
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