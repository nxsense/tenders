package boots.repository;

import boots.entity.Offers;
import boots.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface OfferRepository extends JpaRepository<Offers, Long> {
    @Query("select o from Offers o where o.tender = ?1")
    Optional<Set<Offers>> findByTenderId(@Param("tender") Tender tender);
}
