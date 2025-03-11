package eu.calendrify.calendrifyback.persistence.generalgoaltemplate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneralGoalTemplateRepository extends JpaRepository<GeneralGoalTemplate, Integer> {
    @Query("select g from GeneralGoalTemplate g order by g.topic")
    List<GeneralGoalTemplate> findGeneralGoalTemplatesByOrderAsc();

}