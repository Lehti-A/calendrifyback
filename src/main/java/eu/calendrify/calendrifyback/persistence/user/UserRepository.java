package eu.calendrify.calendrifyback.persistence.user;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where u.email = :email")
    boolean existsByEmail(String email);

    @Query("select u from User u where u.email = :email and u.password = :password and u.status = :status")
    Optional<User> findUserBy(String email, String password, String status);

    User findUserById(@NotNull Integer userId);
}