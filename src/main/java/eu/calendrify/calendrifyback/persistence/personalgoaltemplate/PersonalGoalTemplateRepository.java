package eu.calendrify.calendrifyback.persistence.personalgoaltemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalGoalTemplateRepository extends JpaRepository<PersonalGoalTemplate, Integer> {
    @Query("select p from PersonalGoalTemplate p where p.user.id = :userId order by p.topic")
    List<PersonalGoalTemplate> findPersonalGoalTemplatesBy(Integer userId);
}