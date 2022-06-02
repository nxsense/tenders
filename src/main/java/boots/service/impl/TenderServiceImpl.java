package boots.service.impl;

import boots.entity.Tender;
import boots.repository.TenderRepository;
import boots.service.TenderService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TenderServiceImpl implements TenderService {
    private final TenderRepository tenderRepository;
    private List<Tender> stoppedTenders;

    public List<Tender> getStoppedTenders() {
        return stoppedTenders;
    }

    public void setStoppedTenders(List<Tender> stoppedTenders) {
        this.stoppedTenders = stoppedTenders;
    }

    public TenderServiceImpl(TenderRepository tenderRepository) {
        this.tenderRepository = tenderRepository;
    }

    @Override
    public List<Tender> getAllTenders() {
        return tenderRepository.findAll();
    }

    @Override
    public List<Tender> getAllTenders(String sortBy, String order) {
        if(order == "ascending") return tenderRepository.findAll(Sort.by(sortBy).ascending());
        return tenderRepository.findAll(Sort.by(sortBy).descending());
    }

//    @Override
//    public Optional<List<Tender>> search(String text) {
//        return tenderRepository.findTendersByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCase(text);
//    }

    @Override
    public void stopTender(Long id) {
       Tender tender =  tenderRepository.findById(id).get();
       stoppedTenders.add(tender);
       tenderRepository.delete(getTenderById(id).get());
    }

    @Override
    public void startTender(Long id) {
        for (Tender tender:stoppedTenders) {
            if (tender.getId() == id) addTender(tender);
        }
    }

    @Override
    public void tenderDelete(Long id) {
        tenderRepository.deleteById(id);
    }

    @Override
    public Tender addTender(Tender tender) {
        return tenderRepository.save(tender);
    }

    @Override
    public Optional<Tender> getTenderById(Long id) {
        return tenderRepository.findById(id);
    }
}
