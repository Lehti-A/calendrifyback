package eu.calendrify.calendrifyback.service.step;

import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.step.Step;
import eu.calendrify.calendrifyback.persistence.step.StepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StepService {

    private final StepRepository stepRepository;

    public void updateStep(Integer stepId, Integer count) {
        Step step = getSelectedStep(stepId);
        step.setCount(count);
        stepRepository.save(step);
    }

    private Step getSelectedStep(Integer stepId) {
        Step step = stepRepository.findById(stepId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        return step;
    }

}
