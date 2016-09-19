package web.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsController {

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("name", "Azure Restaurant & Bar");
        model.addAttribute("address", "Address: 225 Front Street West, Toronto, Ontario M5V 2X3");;
        model.addAttribute("phone", "Phone: 1-416-597-8142");
        model.addAttribute("email", "Email: azure@ihg.com");
        model.addAttribute("map", "Map:");
        return "client/contacts";
    }



}
