package eu.calendrify.calendrifyback.persistence.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.day.id = :dayId")
    List<Image> findImageBy(Integer dayId);
}