package boots.controller;

import boots.entity.Offers;
import boots.entity.Tender;
import boots.entity.User;
import boots.service.impl.OffersServiceImpl;
import boots.service.impl.TenderServiceImpl;
import boots.service.impl.UserServiceImpl;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class TenderDetailsController {
    private final TenderServiceImpl tenderService;
    private final UserServiceImpl userService;
    private final OffersServiceImpl offersService;

    @Autowired
    public TenderDetailsController(TenderServiceImpl tenderService, UserServiceImpl userService, OffersServiceImpl offersService) {
        this.tenderService = tenderService;
        this.userService = userService;
        this.offersService = offersService;
    }

    @RequestMapping(value = "/tendDetails", method = RequestMethod.GET)
    public String tendDetails(@RequestParam int tenderId, Model model, Principal principal) {
        model.addAttribute("user", userService.findUserByName(principal.getName()));
        model.addAttribute("tender", tenderService.getTenderById(tenderId));
        return "tenderDetails/details";
    }

    @RequestMapping(value = "/doOffer", method = RequestMethod.GET)
    public String doOffer(@RequestParam int tenderId, Model model, Principal principal) {
        Tender tender = tenderService.getTenderById(tenderId).get();
        User user = userService.findUserByName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("tender", tender);
        return "tenderDetails/doOffer";
    }

    @RequestMapping(value = "/doOffer", method = RequestMethod.POST)
    public String offerAccepted(@ModelAttribute User user, BindingResult result,
                                @RequestParam  int tenderId, Principal principal, Model model, Offers offer) {
        Tender tender = tenderService.getTenderById(tenderId).get();
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("tender", tender);
            return "tenderDetails/doOffer";
        }
        offersService.save(offer);
        model.addAttribute("offer", offer);
        return "redirect:/";
    }
}
