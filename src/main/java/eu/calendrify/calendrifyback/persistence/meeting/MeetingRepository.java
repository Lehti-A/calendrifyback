package eu.calendrify.calendrifyback.persistence.meeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
    @Query("select m from Meeting m where m.day.id = :dayId order by m.time")
    List<Meeting> findMeetingBy(Integer dayId);
}