package eu.calendrify.calendrifyback.service.mood;

import eu.calendrify.calendrifyback.controller.mood.dto.MoodInfo;
import eu.calendrify.calendrifyback.controller.mood.dto.NewMood;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import eu.calendrify.calendrifyback.persistence.mood.Mood;
import eu.calendrify.calendrifyback.persistence.mood.MoodMapper;
import eu.calendrify.calendrifyback.persistence.mood.MoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoodService {

    private final DayRepository dayRepository;
    private final MoodRepository moodRepository;
    private final MoodMapper moodMapper;


    public List<MoodInfo> findMoodInfos(Integer dayId) {
        List<Mood> moods = moodRepository.findMoodBy(dayId);
        List<MoodInfo> moodInfos = moodMapper.toMoodInfos(moods);
        return moodInfos;
    }

    public void addNewMood(NewMood newMood) {
        Mood mood = createNewMood(newMood);
        moodRepository.save(mood);
    }

    public void deleteMood(Integer moodId) {
        Mood mood = moodRepository.getReferenceById(moodId);
        moodRepository.delete(mood);
    }

    private Mood createNewMood(NewMood newMood) {
        Day day = dayRepository.getReferenceById(newMood.getDayId());
        Mood mood = moodMapper.toMood(newMood);
        mood.setDay(day);
        return mood;
    }


}
