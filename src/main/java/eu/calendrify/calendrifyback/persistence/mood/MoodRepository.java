package eu.calendrify.calendrifyback.persistence.mood;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood, Integer> {
}