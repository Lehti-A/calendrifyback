package eu.calendrify.calendrifyback.service.personalgoal;

import eu.calendrify.calendrifyback.controller.personalgoal.dto.NewPersonalGoal;
import eu.calendrify.calendrifyback.controller.personalgoal.dto.PersonalGoalInfo;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.personalgoal.PersonalGoal;
import eu.calendrify.calendrifyback.persistence.personalgoal.PersonalGoalMapper;
import eu.calendrify.calendrifyback.persistence.personalgoal.PersonalGoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PersonalGoalService {
    private final PersonalGoalRepository personalGoalRepository;
    private final PersonalGoalMapper personalGoalMapper;
    private final DayRepository dayRepository;


    public void addPersonalGoal(NewPersonalGoal newPersonalGoal, Integer dayId) {
        Day day = dayRepository.findById(dayId).orElseThrow(() ->
                new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        PersonalGoal personalGoal = personalGoalMapper.toPersonalGoal(newPersonalGoal);
        personalGoal.setDay(day);
        personalGoalRepository.save(personalGoal);
    }

    public List<PersonalGoalInfo> findPersonalGoalInfos(Integer dayId) {
        List<PersonalGoal> personalGoals = personalGoalRepository.findPersonalGoalsBy(dayId);
        return personalGoalMapper.toPersonalGoalInfos(personalGoals);
    }

    public void updatePersonalGoalStatus(Integer personalGoalId, Boolean isDone) {
        PersonalGoal personalGoal = personalGoalRepository.findById(personalGoalId).orElseThrow(() ->
                new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        personalGoal.setIsDone(isDone);
        personalGoalRepository.save(personalGoal);
    }

    public void deletePersonalGoal(Integer personalGoalId) {
        PersonalGoal personalGoal = personalGoalRepository.findById(personalGoalId).orElseThrow(() ->
                new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));
        personalGoalRepository.delete(personalGoal);
    }
}