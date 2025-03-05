package eu.calendrify.calendrifyback.persistence.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query("select a from Activity a where a.day.id = :dayId order by a.isDone, a.topic")
    List<Activity> findActivityBy(Integer dayId);
}