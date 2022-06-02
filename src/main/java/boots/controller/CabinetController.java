package boots.controller;

import boots.entity.Tender;
import boots.entity.User;
import boots.service.impl.TenderServiceImpl;
import boots.service.impl.UserServiceImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

@RequestMapping()
public class CabinetController {
    private final TenderServiceImpl tenderService;
    private final UserServiceImpl userService;

    public CabinetController(TenderServiceImpl tenderService, UserServiceImpl userService) {
        this.tenderService = tenderService;
        this.userService = userService;
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cabinet(Model model, Principal principal) {
        User user = userService.findUserByName(principal.getName()).get();
        model.addAttribute("user", user);
        return "cabinet/myCabinet";
    }

//    @RequestMapping(value = "myTenders", method = RequestMethod.GET)
//    public String getMyTenders(Model model, Principal principal) {
//        model.addAttribute("tenders", tenderService.getUsersTenders(principal.getName()));
//        return "cabinet/myTenders";
//    }

    @RequestMapping(value = "newTender", method = RequestMethod.GET)
    public String newTender(Model model) {
        model.addAttribute("tender", new Tender());
        return "cabinet/tenderForm";
    }

    @RequestMapping(value = "newTender", method = RequestMethod.POST)
    public String createTender(@ModelAttribute Tender tender, BindingResult tendResult,
                               Principal principal) {
        if (tendResult.hasErrors()) {
            return "cabinet/tenderForm";
        }
        tenderService.addTender(tender);
        return "redirect:/cabinet";
    }


}
