package eu.calendrify.calendrifyback.service.step;

import eu.calendrify.calendrifyback.controller.step.dto.StepInfo;
import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.step.Step;
import eu.calendrify.calendrifyback.persistence.step.StepMapper;
import eu.calendrify.calendrifyback.persistence.step.StepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static eu.calendrify.calendrifyback.infrastructure.Error.FOREIGN_KEY_NOT_FOUND;
import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepRepository stepRepository;
    private final StepMapper stepMapper;

    public void updateStep(Integer stepId, Integer count) {
        Step step = getSelectedStep(stepId);
        step.setCount(count);
        stepRepository.save(step);
    }

    private Step getSelectedStep(Integer stepId) {
        return stepRepository.findById(stepId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
    }

    public StepInfo findStepInfo(Integer userId, LocalDate date) {
        Step step = stepRepository.findStepsBy(userId, date).orElseThrow(() -> new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage(), FOREIGN_KEY_NOT_FOUND.getErrorCode()));

        if (step == null) {
            return null;
        }
        return stepMapper.toStepInfo(step);

    }
}