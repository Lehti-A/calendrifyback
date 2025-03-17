package eu.calendrify.calendrifyback.persistence.water;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface WaterRepository extends JpaRepository<Water, Integer> {
    @Query("select (count(w) > 0) from Water w where w.user.id = :userId and w.date = :date")
    boolean waterExistsBy(Integer userId, LocalDate date);

    @Query("select w from Water w where w.user.id = :userId and w.date = :date")
    Optional<Water> findWaterBy(Integer userId, LocalDate date);

}