package ies.p1.rooms_scanner.Controller;
import ies.p1.rooms_scanner.Entities.*;
import ies.p1.rooms_scanner.Repository.RoomsRepository;
import ies.p1.rooms_scanner.Service.RoomsService;
import ies.p1.rooms_scanner.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomsController {
    @Autowired
    private RoomsRepository RoomsRepository;
    @Autowired
    RoomsService roomsService;

    @Autowired
    SensorService sensorService;

    //RoomsList Page
    @RequestMapping("/roomsList")
    public String getRoomsLists() { return "/Rooms-List";}



    @RequestMapping("/home")
    public String Home(Model model) { // pagina inicial com duas seçoes, uma q mostra o numero de salas de estudo livres para reserva e outra q mostra o numero de lugares livres (total ou separar logo por departamentos?)
        return "/index";
    }
    @RequestMapping("/contactUs")
    public String Contacts() { return "/ContactUs"; }

    @RequestMapping("/roomsStatistics")
    public String getStatistics(Model model) { // pagina inicial com duas seçoes, uma q mostra o numero de salas de estudo livres para reserva e outra q mostra o numero de lugares livres (total ou separar logo por departamentos?)
        return "/Rooms-Statistics";
    }

    @RequestMapping("/roomReservations")
    public String getReservations() {
        return "/Room-Reservations";
    }

  
   @RequestMapping("/configurations")
   public String getConfigurations(Model model) { // pagina inicial com duas seçoes, uma q mostra o numero de salas de estudo livres para reserva e outra q mostra o numero de lugares livres (total ou separar logo por departamentos?)
        return "/Configurations";
    }





    















    //TODO: mapear o ESTADO das salas de forma individual ou apresentar essa info na pagina de estatisticas AKA pagina inicial no sistema

    @PostMapping("/roomreservations") // form que pede email do responsavel pela reserva, numero de ocupantes da sala, tempo de ocupacao previsto, data+hora, comboBox pra selecionar a sala
    public String submitBooking(Booking b, Model model) { //Associar À pagina de login da ua ou apenas simular isso (pedindo o mail e o nome)?
        model.addAttribute("booking", new Booking());
        model.addAttribute("submitted", true);
        return "/Room-Reservations";
    }




    @GetMapping("/bookingsList")
    public String getRoomBookings(Model model) {  //TODO: pagina disponivel apenas para funcionarias da biblioteca
        return "/bookingsList";
    }

}
