package boots.service.impl;

import boots.entity.Offers;
import boots.entity.Tender;
import boots.repository.OfferRepository;
import boots.service.OffersService;

import java.util.Optional;
import java.util.Set;

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
    public Optional<Set<Offers>> findByTenderId(Tender tender) {
        return offerRepository.findByTenderId(tender);
    }
}
