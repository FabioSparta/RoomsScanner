package ies.p1.rooms_scanner.Controller;
import ies.p1.rooms_scanner.Entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomsController {
    @RequestMapping("/")
    public String getStatistics(Model model) { // pagina inicial com duas seçoes, uma q mostra o numero de salas de estudo livres para reserva e outra q mostra o numero de lugares livres (total ou separar logo por departamentos?)
        return "rooms/roomsStatistics";
    }

    //TODO: mapear o ESTADO das salas de forma individual ou apresentar essa info na pagina de estatisticas AKA pagina inicial no sistema

    @PostMapping("/bookingForm") // form que pede email do responsavel pela reserva, numero de ocupantes da sala, tempo de ocupacao previsto, data+hora, comboBox pra selecionar a sala
    public String submitBooking(Bookings b, Model model) { //Associar À pagina de login da ua ou apenas simular isso (pedindo o mail e o nome)?
        model.addAttribute("booking", new Bookings());
        model.addAttribute("submitted", true);
        return "rooms/bookingForm";
    }

   @GetMapping("/roomsList")
   //TODO: fazer uma pagina com lista de todos os departamentos e total de espaços livres, com barra de pesquisa sobre a lista e ainda decidir se colocar opçao de expandir aquele room ou "abrir" novo mapeamento
   public String getRoomsList(Model model) {
       return "rooms/roomsList";
    }

    @GetMapping("/bookingsList")
    public String getRoomBookings(Model model) {  //TODO: pagina disponivel apenas para funcionarias da biblioteca
        return "rooms/bookingsList";
    }

}
