package boots.repository;

import boots.entity.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OfferRepository extends JpaRepository<Offers, Long> {
        @Query("SELECT o FROM Offers o WHERE o.tender.id= :id")
        Optional<Set<Offers>> findByTenderId(@Param("id") Long id);
}
