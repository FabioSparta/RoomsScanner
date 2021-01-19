package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.Notification;
import ies.p1.rooms_scanner.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class NotificationsController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping(value = "/roomNotification")
    public ResponseEntity<Object> createNotifications(@RequestParam String msg) {
        String[] data = msg.split("#");
        int id = notificationService.totalNotifications();
        Notification n = new Notification(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3],id);
        notificationService.createNotification(n);
        notificationService.notify(n.getMessage(), "Admin" ); //TODO: select * from users where ADMIN e enviar pra todos
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    //Get
    @GetMapping(value = "/notifications")
    public ResponseEntity<Object> getNotifications(@RequestParam(required = false,defaultValue ="") String id) {
        if(id.equals("")) return new ResponseEntity<>(notificationService.getNotifications(), HttpStatus.OK);
        try {
            int notiId = Integer.parseInt(id);
            Notification n = notificationService.getNotificationById(notiId);
            if (n == null)
                return new ResponseEntity<>("Error, notification not found!", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(n, HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>("Error with notification id", HttpStatus.NOT_FOUND);
        }
    }

    //Delete
    @DeleteMapping(value = "/deleteNotification/{id}")
    public ResponseEntity<Object> deleteNotification(@PathVariable("id") int id) {
        if (notificationService.deleteNotification(id))
            return new ResponseEntity<>("Notification deleted successfully", HttpStatus.OK);
        else
            return  new ResponseEntity<>("Notification not deleted", HttpStatus.NOT_ACCEPTABLE);
    }
}
