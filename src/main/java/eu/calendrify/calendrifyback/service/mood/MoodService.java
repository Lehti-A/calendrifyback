package eu.calendrify.calendrifyback.service.mood;

import eu.calendrify.calendrifyback.infrastructure.exception.DataNotFoundException;
import eu.calendrify.calendrifyback.persistence.mood.Mood;
import eu.calendrify.calendrifyback.persistence.mood.MoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static eu.calendrify.calendrifyback.infrastructure.Error.PRIMARY_KEY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MoodService {

    private final MoodRepository moodRepository;


    public void updateMood(Integer moodId, String state) {
        Mood mood = getSelectedMood(moodId);
        mood.setState(state);
        moodRepository.save(mood);
    }

    private Mood getSelectedMood(Integer moodId) {
        Mood mood = moodRepository.findById(moodId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
        return mood;
    }

}
