package boots.repository;

import boots.entity.Offers;
import boots.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenderRepository extends JpaRepository<Tender, Long> {
}
