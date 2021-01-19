package ies.p1.rooms_scanner.Service;

import ies.p1.rooms_scanner.Entities.Notification;
import ies.p1.rooms_scanner.Repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Service class for sending notification messages.
 */
@Service
public class NotificationService {
  
  // The SimpMessagingTemplate is used to send Stomp over WebSocket messages.
  @Autowired
  private SimpMessagingTemplate messagingTemplate;
  @Autowired
  private NotificationsRepository repository;

  //@Autowired
  //private JavaMailSender mailSender;
  
  /**
   * Send notification to users subscribed on channel "/user/queue/notify".
   *
   * @param notification The notification message.
   */
  public void notify(String notification, String mail) {
    messagingTemplate.convertAndSend("/queue/notify",  notification);

    // NOTIFY BY EMAIL
    System.out.println("A enviar email...");
    /*SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(mail);
    message.setSubject("IMPORTANT: Room overloaded!");
    message.setText(notification);
    mailSender.send(message);*/
    System.out.println("enviada");
    return;
  }

  public boolean createNotification(Notification n) {
    if(repository.existsById(n.getId())){
      return false;
    }
    repository.save(n);
    return true;
  }
  public boolean deleteNotification(int id) {
    if(!repository.existsById(id))
      return false;
    repository.deleteById(id);
    return true;
  }

  public Collection<Notification> getNotifications() {
    return repository.findAllByOrderByDateDescTimeDesc();
  }
  public Notification getNotificationById(int id) {return repository.getNotificationById(id);}

  public int totalNotifications(){return  repository.totalNotifications();};
}
