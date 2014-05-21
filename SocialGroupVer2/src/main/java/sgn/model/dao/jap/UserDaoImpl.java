package sgn.model.dao.jap;

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
public class UserDaoImpl implements UserDao{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAccount(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String email, String password) {
		User user = null;
		try{
		user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2", 
				User.class).setParameter(1, email).setParameter(2, password).getSingleResult();
		}
		catch(EmptyResultDataAccessException e )
		{
			return null;
		}
		catch(NoResultException e)
		{
			return null;
		}
		return user;
	}

	@Override
	@Transactional
	public User update(User u, Group g) {


		GroupFriend gf = new GroupFriend(u, g);
		
		System.out.println("here " + gf.getFriendId() + "  " +  gf.getGroupId() );
		entityManager.merge(gf);
		System.out.println("here " + gf.getFriendId() + " ---------- " +  gf.getGroupId() );
		
		return null;  
		 
	}
	
	

}
