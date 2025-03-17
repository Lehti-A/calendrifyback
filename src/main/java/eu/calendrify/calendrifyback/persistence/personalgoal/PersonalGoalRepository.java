package eu.calendrify.calendrifyback.persistence.personalgoal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalGoalRepository extends JpaRepository<PersonalGoal, Integer> {
    @Query("select p from PersonalGoal p where p.day.id = :dayId order by p.topic")
    List<PersonalGoal> findPersonalGoalsBy(Integer dayId);
}