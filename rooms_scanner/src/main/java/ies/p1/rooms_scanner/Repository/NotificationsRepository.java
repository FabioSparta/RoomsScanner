package ies.p1.rooms_scanner.Repository;

import ies.p1.rooms_scanner.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notification,Integer> {
    List<Notification> findAllByOrderByTimeDesc(); // TODO: CONFIRMAR Q ESTA A FUNCIONAR
    Notification getNotificationById (int id);

    @Query(value="select count(*) from notifications",nativeQuery = true)
    int totalNotifications();
}
