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


    public void addNewActivity(NewActivity newActivity) {
        createAndSaveActivity(newActivity);
    }

    public void updateActivityStatus(Integer activityId, Boolean isDone) {
        updateAndSaveActivityStatus(activityId, isDone);
    }

    public List<ActivityInfo> findActivityInfos(Integer dayId) {
        List<Activity> activities = getActivitiesBy(dayId);
        return activityMapper.toActivityInfos(activities);
    }

    public void deleteActivity(Integer activityId) {
        getAndDeleteActivity(activityId);
    }

    private void createAndSaveActivity(NewActivity newActivity) {
        Activity activity = createActivity(newActivity);
        activityRepository.save(activity);
    }

    private Activity createActivity(NewActivity newActivity) {
        Day day = getDay(newActivity);
        Activity activity = activityMapper.toActivity(newActivity);
        activity.setDay(day);
        return activity;
    }

    private void updateAndSaveActivityStatus(Integer activityId, Boolean isDone) {
        Activity activity = getAndUpdateActivity(activityId, isDone);
        activityRepository.save(activity);
    }

    private Activity getAndUpdateActivity(Integer activityId, Boolean isDone) {
        Activity activity = getActivity(activityId);
        activity.setIsDone(isDone);
        return activity;
    }

    private Day getDay(NewActivity newActivity) {
        return dayRepository.getReferenceById(newActivity.getDayId());
    }

    private Activity getActivity(Integer activityId) {
        return activityRepository.getReferenceById(activityId);
    }

    private List<Activity> getActivitiesBy(Integer dayId) {
        return activityRepository.findActivitiesBy(dayId);
    }

    private void getAndDeleteActivity(Integer activityId) {
        Activity activity = getActivity(activityId);
        activityRepository.delete(activity);
    }
}