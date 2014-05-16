package sgn.model.dao.jap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgn.model.Group;
import sgn.model.User;
import sgn.model.dao.GroupDao;
@Repository
public class GroupDaoImpl implements GroupDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Group getGroupById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getIsPublic(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Group> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAll(User user) {
		
		List<Group> groups = null;
		String sql = "SELECT * FROM groups WHERE owner_id = ?1";
		
		try{
		groups = entityManager.createNativeQuery(sql, Group.class)
				.setParameter(1, user.getId()).getResultList();
		}
		catch( EmptyResultDataAccessException e)
		{
			return null;
		}
		catch(NoResultException noE)
		{
			return null;
		}
		
		return groups;
	}

	@Override
	public List<Group> getUserGroup(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Group saveGroup(Group group) {

		return entityManager.merge(group);
	}

}
