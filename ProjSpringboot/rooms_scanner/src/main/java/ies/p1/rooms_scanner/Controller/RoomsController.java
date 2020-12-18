package ies.p1.rooms_scanner.Controller;
import ies.p1.rooms_scanner.Entities.*;
import ies.p1.rooms_scanner.Repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RoomsController {
    @Autowired
    private RoomsRepository RoomsRepository;

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

    @RequestMapping("/roomsList")
    public String getRoomsList(Model model) { // pagina inicial com duas seçoes, uma q mostra o numero de salas de estudo livres para reserva e outra q mostra o numero de lugares livres (total ou separar logo por departamentos?)
        return "/Rooms-List";
    }
    public List<Rooms> getAllRooms(@RequestParam (required = false) String department, @RequestParam (required = false) int floor) {
        if (department != null && floor != -1)
            return RoomsRepository.findAllByDepartmentAndAndFloor(department, floor);
        else if (department != null)
            return RoomsRepository.findAllByDepartment(department);
        else
            return RoomsRepository.findAll();
    }









    //TODO: mapear o ESTADO das salas de forma individual ou apresentar essa info na pagina de estatisticas AKA pagina inicial no sistema

    @PostMapping("/roomreservations") // form que pede email do responsavel pela reserva, numero de ocupantes da sala, tempo de ocupacao previsto, data+hora, comboBox pra selecionar a sala
    public String submitBooking(Bookings b, Model model) { //Associar À pagina de login da ua ou apenas simular isso (pedindo o mail e o nome)?
        model.addAttribute("booking", new Bookings());
        model.addAttribute("submitted", true);
        return "/Room-Reservations";
    }

   @GetMapping("/roomsList")
   //TODO: fazer uma pagina com lista de todos os departamentos e total de espaços livres, com barra de pesquisa sobre a lista e ainda decidir se colocar opçao de expandir aquele room ou "abrir" novo mapeamento
   public String getRoomsLists(Model model) {
       return "/Rooms-List";
    }

    @GetMapping("/bookingsList")
    public String getRoomBookings(Model model) {  //TODO: pagina disponivel apenas para funcionarias da biblioteca
        return "/bookingsList";
    }

}
