package boots.service.impl;

import boots.entity.Offers;
import boots.repository.OfferRepository;
import boots.service.OffersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class OffersServiceImpl implements OffersService {

    private final OfferRepository offerRepository;

    public OffersServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offers save(Offers offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Optional<Set<Offers>> findByTenderId(int id) {
        return offerRepository.findByTenderId(id);
    }
}
