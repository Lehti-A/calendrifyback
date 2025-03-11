package eu.calendrify.calendrifyback.persistence.step;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface StepRepository extends JpaRepository<Step, Integer> {
    @Query("select s from Step s where s.user.id = :userId and s.date = :date")
    Optional<Step> findStepsBy(Integer userId, LocalDate date);

    @Query("select (count(s) > 0) from Step s where s.user.id = :userId and s.date = :date")
    boolean stepsExistsBy(Integer userId, LocalDate date);

}