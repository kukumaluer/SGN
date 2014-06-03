package sgn.model.dao.jap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgn.model.Notifications;
import sgn.model.User;
import sgn.model.dao.NotificationsDao;

@Repository
public class NotificationsDaoImpl implements NotificationsDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Notifications> getNotifications(User groupOwner) {
		List<Notifications> notifications = null;

		String sql = "Select n from Notifications n where n.notified = ?1";
		try {
			notifications = entityManager.createQuery(sql, Notifications.class)
					.setParameter(1, groupOwner).getResultList();

		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}
		return notifications;
	}

	@Override
	@Transactional
	public void saveNotification(Notifications notification) {
		entityManager.merge(notification);

	}

	@Override
	@Transactional
	public void deleteNotification(User u, Integer gId, Integer fId) {
		String sql = "delete from notifications where friend_to_add_id = ?1 "
				+ " and adding_group_id = ?2 and notify_user_id =?3 ";

		entityManager.createNativeQuery(sql).setParameter(1, fId)
				.setParameter(2, gId).setParameter(3, u).executeUpdate();

	}

	@Override
	@Transactional
	public void deleteNotification(Notifications dNtf) {
		String sql = "delete from notifications where friend_to_add_id = ?1 "
				+ " and adding_group_id = ?2 and notify_user_id =?3 ";

		entityManager.createNativeQuery(sql)
				.setParameter(1, dNtf.getFriendId())
				.setParameter(2, dNtf.getGroudId())
				.setParameter(3, dNtf.getNotified()).executeUpdate();

	}

}
