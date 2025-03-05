package eu.calendrify.calendrifyback.service.activity;


import eu.calendrify.calendrifyback.controller.activity.dto.ActivityInfo;
import eu.calendrify.calendrifyback.controller.activity.dto.NewActivity;
import eu.calendrify.calendrifyback.persistence.activity.Activity;
import eu.calendrify.calendrifyback.persistence.activity.ActivityMapper;
import eu.calendrify.calendrifyback.persistence.activity.ActivityRepository;
import eu.calendrify.calendrifyback.persistence.day.Day;
import eu.calendrify.calendrifyback.persistence.day.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final DayRepository dayRepository;
    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    public List<ActivityInfo> findActivityInfos(Integer dayId) {
        List<Activity> activities = activityRepository.findActivityBy(dayId);
        List<ActivityInfo> activityInfos = activityMapper.toActivityInfos(activities);
        return activityInfos;
    }

    public void addNewActivity(NewActivity newActivity) {
        Activity activity = createActivity(newActivity);
        activityRepository.save(activity);
    }

    public void deleteActivity(Integer activityId) {
        Activity activity = activityRepository.getReferenceById(activityId);
        activityRepository.delete(activity);
    }

    private Activity createActivity(NewActivity newActivity) {
        Day day = dayRepository.getReferenceById(newActivity.getDayId());
        Activity activity = activityMapper.toActivity(newActivity);
        activity.setDay(day);
        return activity;
    }


}
