package boots.controller;

import boots.entity.Tender;
import boots.entity.User;
import boots.service.impl.TenderServiceImpl;
import boots.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final TenderServiceImpl tenderService;
    private final UserServiceImpl userService;

    @Autowired
    public HomeController(TenderServiceImpl tenderService, UserServiceImpl userService) {
        this.tenderService = tenderService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:tenders?sortBy=date&orderBy=ascending";
    }

    @RequestMapping(value = "/tenders", method = RequestMethod.GET)
    public String gtAllTenders(@RequestParam(defaultValue = "date") String sortBy, @RequestParam(defaultValue = "ascending") String orderBy,
                               Model model, Principal principal){
        List<Tender> tenders;
        tenders = tenderService.getAllTenders(sortBy, orderBy);
        model.addAttribute("principal", principal);
        model.addAttribute("tenders", tenders);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("orderBy", orderBy);
        return "allTenders";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Неверный логин или пароль");
        }
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processingRegistration(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
       // String password = user.getPassword();
        userService.createNewUser(user);
        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping(value = "/rules", method = RequestMethod.GET)
    public String rules(Model model, Principal principal) {
        model.addAttribute("principal", principal);
        return "rules";
    }
}
