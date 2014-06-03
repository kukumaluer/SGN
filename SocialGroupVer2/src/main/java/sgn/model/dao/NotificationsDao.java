package sgn.model.dao;

import java.util.List;

import sgn.model.Notifications;
import sgn.model.User;

public interface NotificationsDao {
	
	List<Notifications> getNotifications(User groupOwner);
	void saveNotification(Notifications notification);
	void deleteNotification(User usr, Integer gId, Integer fId);
	void deleteNotification(Notifications deleteNotification);

}
