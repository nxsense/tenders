package boots.repository;

import boots.entity.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offers, Long> {
}
