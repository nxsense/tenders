package boots.controller;

import boots.entity.Offers;
import boots.entity.Tender;
import boots.entity.User;
import boots.exeptions.ResourceNotFoundException;
import boots.service.impl.OffersServiceImpl;
import boots.service.impl.TenderServiceImpl;
import boots.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping(value = "rest")
@RestController
public class TenderRestController {
    private final TenderServiceImpl tenderService;
    private final UserServiceImpl userService;

    private final OffersServiceImpl offersService;
    @Autowired
    public TenderRestController(TenderServiceImpl tenderService, UserServiceImpl userService, UserServiceImpl userService1, OffersServiceImpl offersService) {
        this.tenderService = tenderService;
        this.userService = userService1;
        this.offersService = offersService;
    }

    @GetMapping(value = "users/{name}")
    public Optional<User> getUser (@PathVariable String name){
        Optional<User> user = userService.findUserByName(name);
        if(user == null) throw new ResourceNotFoundException();
        return user;
    }
    @GetMapping(value = "users/{id}")
    public Optional<User> getUser (@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user == null) throw new ResourceNotFoundException();
        return user;
    }
    @PostMapping(value = "users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        userService.createNewUser(user);
        return user;
    }

    @GetMapping(value = "tenders/{id}")
    public Optional<Tender> getTender(@PathVariable Long id){
        Optional<Tender> tender=tenderService.getTenderById(id);
        if (tender==null){
            throw new ResourceNotFoundException();
        }
        return tender;
    }

    @GetMapping(value = "tenders")
    public List<Tender> tenders(@RequestParam(value = "sortBy", required = false) String sortBy, @RequestParam(value = "orderBy", required = false) String orderBy){
        List<Tender> list;
        if(sortBy == null || orderBy == null){
             list = tenderService.getAllTenders();
        }
        else list = tenderService.getAllTenders(sortBy, orderBy);
        if (list.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return list;
    }

    @GetMapping(value = "tenders/{id}/offers")
    public Optional<Set<Offers>> getOffers(@PathVariable Long id){
        Optional<Set<Offers>> set = offersService.findByTenderId(id);
        if(set.isPresent()){
            throw new ResourceNotFoundException();
        }
        return set;
    }

    @DeleteMapping(value = "tenders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTender(@PathVariable Long id){
        tenderService.tenderDelete(id);
    }
//    @GetMapping(value = "tenders/search")
//    public Optional<List<Tender>> searchTenders(@RequestParam String text){
//        Optional<List<Tender>> list = tenderService.search(text);
//        if(list.isEmpty())
//            throw new ResourceNotFoundException();
//        return list;
//    }
}
