package eu.calendrify.calendrifyback.persistence.focus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FocusRepository extends JpaRepository<Focus, Integer> {


    @Query("""
            select f from Focus f
            where f.user.id = :userId and f.monthNumber = :monthNumber and f.year = :year and f.type = :type
            order by f.isSelected, f.topic""")
    List<Focus> findFocusBy(Integer userId, Integer monthNumber,  Integer year,  String type);


}