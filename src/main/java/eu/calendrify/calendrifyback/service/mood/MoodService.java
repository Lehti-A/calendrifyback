package eu.calendrify.calendrifyback.service.mood;

import eu.calendrify.calendrifyback.controller.mood.dto.MoodInfo;
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
        return moodRepository.findById(moodId)
                .orElseThrow(() -> new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage(), PRIMARY_KEY_NOT_FOUND.getErrorCode()));
    }

    public MoodInfo findMoodInfo(Integer dayId) {
        Mood mood = moodRepository.findMoodBy(dayId);
        if (mood == null) {
            return null;
        }
        MoodInfo moodInfo = new MoodInfo();
        moodInfo.setMoodId(mood.getId());
        moodInfo.setState(mood.getState());
        return moodInfo;
    }
}
