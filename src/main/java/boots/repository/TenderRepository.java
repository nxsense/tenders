package boots.repository;

import boots.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Integer> {
    //Optional<List<Tender>> findTendersByTitleContainingIgnoreCase(String text);
   // @Query

    List<Tender> getTendersByUserName(String name);

}
