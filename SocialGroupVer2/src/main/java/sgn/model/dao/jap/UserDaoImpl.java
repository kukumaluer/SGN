package sgn.model.dao.jap;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgn.model.Group;
import sgn.model.GroupFriend;
import sgn.model.User;
import sgn.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public User saveUser(User user) {

		return entityManager.merge(user);
	}

	@Override
	public User getUser(User user) {

		return null;
	}

	@Override
	public User getUser(Integer id) {

		String sql = "select id, first_name, last_name, email, password, enabled from users where id = ?1";
		User user = null;

		try {
			user = (User) entityManager.createNativeQuery(sql, User.class)
					.setParameter(1, id).getSingleResult();

		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException e) {

			return null;
		}

		return user;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAccount(String email) {
		User u = null;
		String sql = "SELECT u FROM User u where u.email = ?1";
		try {
			u = entityManager.createQuery(sql, User.class)
					.setParameter(1, email).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return false;
		} catch (NoResultException e) {
			return false;
		}


		return true;
	}

	@Override
	public User getUser(String email, String password) {
		User user = null;
		try {
			user = entityManager
					.createQuery(
							"SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2",
							User.class).setParameter(1, email)
					.setParameter(2, password).getSingleResult();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
		return user;
	}

	@Override
	@Transactional
	public User update(User u, Group g) {

		GroupFriend gf = new GroupFriend(u, g);

		entityManager.merge(gf);

		return null;

	}

}
