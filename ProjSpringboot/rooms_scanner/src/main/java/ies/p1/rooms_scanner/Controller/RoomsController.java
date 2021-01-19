package ies.p1.rooms_scanner.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomsController {

    @RequestMapping("/roomsList")
    public String getRoomsLists() { return "/Rooms-List"; }

    @GetMapping("/home")
    public String Home() { return "/home"; }

    @RequestMapping("/contactUs")
    public String Contacts() { return "/ContactUs"; }

    @RequestMapping("/roomsStatistics")
    public String getStatistics() { return "/Rooms-Statistics";}

    @RequestMapping("/roomReservations")
    public String getReservations() { return "/Room-Reservations"; }

    @RequestMapping("/configurations")
    public String getConfigurations(Model model) { return "/Configurations"; }
}



    