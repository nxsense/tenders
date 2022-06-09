package boots.repository;

import boots.entity.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OfferRepository extends JpaRepository<Offers, Integer> {
        Optional<Set<Offers>> findByTenderId(int id);
}
