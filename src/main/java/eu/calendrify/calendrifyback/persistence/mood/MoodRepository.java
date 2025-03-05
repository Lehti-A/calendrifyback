package eu.calendrify.calendrifyback.persistence.mood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoodRepository extends JpaRepository<Mood, Integer> {
    @Query("select m from Mood m where m.day.id = :dayId")
    List<Mood> findMoodBy(Integer dayId);
}