package boots.service.impl;

import boots.entity.Offers;
import boots.entity.Tender;
import boots.repository.OfferRepository;
import boots.service.OffersService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
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
    public Optional<Set<Offers>> findByTenderId(Long id) {
        return offerRepository.findByTenderId(id);
    }
}
