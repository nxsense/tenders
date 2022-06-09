package boots.service;

import boots.entity.Offers;

import java.util.Optional;
import java.util.Set;

public interface OffersService {
    Offers save(Offers offer);
    Optional<Set<Offers>> findByTenderId(int id);
}
