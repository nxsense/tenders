package boots.service;

import boots.entity.Offers;
import boots.entity.Tender;

import java.util.Optional;
import java.util.Set;

public interface OffersService {
    Offers save(Offers offer);
    Optional<Set<Offers>> findByTenderId(Long id);
}
