package eu.calendrify.calendrifyback.persistence.mood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MoodRepository extends JpaRepository<Mood, Integer> {
    @Query("select m from Mood m where m.day.id = :dayId")
    Mood findMoodBy(Integer dayId);
}