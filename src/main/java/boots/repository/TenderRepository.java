package boots.repository;

import boots.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Long> {
    //Optional<List<Tender>> findTendersByTitleContainingIgnoreCase(String text);
    @Query("SELECT t FROM Tender t WHERE t.user.name = :name")

    List<Tender> getTendersByUserName(@Param("name") String name);

}
