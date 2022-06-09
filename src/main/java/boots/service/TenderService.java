package boots.service;

import boots.entity.Tender;

import java.util.List;
import java.util.Optional;

public interface TenderService {
    List<Tender> getAllTenders();
    List<Tender> getAllTenders(String sortBy, String order);
    //Optional <List<Tender>> search(String text);
    void stopTender(int id);
    void startTender(int id);
    void tenderDelete(int id);
    Tender addTender (Tender tender);
    Optional<Tender> getTenderById(int id);
    List<Tender> getTenderByUserName(String name);
}
