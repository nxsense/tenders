package boots.repository;

import boots.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("select u FROM User as u WHERE u.name= :name")
    Optional<User> findByName(@Param("name") String name);


}
