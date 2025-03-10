package eu.calendrify.calendrifyback.persistence.day;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Integer> {
    @Query("select (count(d) > 0) from Day d where d.user.id = :userId and d.date = :date and d.type = :type")
    boolean dayExistsBy(Integer userId, LocalDate date, String type);

    @Query("select d from Day d where d.user.id = :userId and d.type = :type and d.date = :date")
    Optional<Day> findDayBy(Integer userId, String type, LocalDate date);
}