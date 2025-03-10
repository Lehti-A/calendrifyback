package eu.calendrify.calendrifyback.persistence.step;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface StepRepository extends JpaRepository<Step, Integer> {
    @Query("select (count(s) > 0) from Step s where s.user.id = :userId and s.date = :date")
    boolean stepsExistsBy(Integer userId, LocalDate date);

}