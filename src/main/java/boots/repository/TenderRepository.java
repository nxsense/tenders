package boots.repository;

import boots.entity.Offers;
import boots.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Long> {


}
