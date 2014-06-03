package sgn.model.dao.jap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.ejb.criteria.CriteriaQueryImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgn.model.Group;
import sgn.model.GroupFriend;
import sgn.model.User;
import sgn.model.dao.GroupDao;

@Repository
public class GroupDaoImpl implements GroupDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Group getGroupById(Integer id) {
		String sql = "SELECT g FROM Group g WHERE id = ?1";
		Group group = null;

		try {
			group = entityManager.createQuery(sql, Group.class)
					.setParameter(1, id).getSingleResult();

		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return group;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAll(boolean value) {

		List<Group> groups = null;
		String sql = "SELECT * FROM groups WHERE ispublic = ?1";
		try {
			groups = entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, value).getResultList();

		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return groups;

	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Group> getAllPriv() {
//
//		List<Group> groups = null;
//		String sql = "SELECT * FROM groups WHERE ispublic = ?1";
//		try {
//			groups = entityManager.createNativeQuery(sql, Group.class)
//					.setParameter(1, false).getResultList();
//
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		} catch (NoResultException noE) {
//			return null;
//		}
//
//		return groups;
//
//	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAll(User user) {

		List<Group> groups = null;
		String sql = "SELECT * FROM groups WHERE owner_id = ?1";

		try {
			groups = entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, user.getId()).getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> inGroup(Integer id) {

		List<Integer> ingroup;

		String sql = "SELECT id FROM groups g "
				+ "inner join group_friend_id gu " + "on g.id = gu.group_id"
				+ " where friend_id = ?1";

		try {
			ingroup = entityManager.createNativeQuery(sql, Integer.class)
					.setParameter(1, id).getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return ingroup;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAllExceptinGroup(User user) {

		List<Group> ingroup;

		// String sql =
		// "select g.id, g.category, g.group_name, g.ispublic, g.owner_id from groups g"
		// +
		// " inner join group_friend_id gu " +
		// "on friend_id  !=  ?1" +
		// " and g.id != gu.group_id and g.ispublic = true ";

		String sql = "SELECT g.id , g.category, g.group_name, g.ispublic, g.owner_id from groups g, group_friend_id g2 "
				+ " where ( g2.friend_id != ?1 and g.owner_id != ?2 and g.ispublic = true ) ";

		try {
			ingroup = entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, user.getId())
					.setParameter(2, user.getId()).getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return ingroup;
	}

	@Override
	public List<Group> getAllInGroup(User user) {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getGroupsIamIn(Group group, User user) {

		// String sql =
		// "select g.id, g.category, g.group_name, g.ispublic, g.owner_id from groups "
		// +
		// "g, group_friend_id g2 where g2.friend_id = ?1 and g.owner_id != ?2";

		// String sql2 = "select distinct( g ) from Group " +
		// "g, GroupFriend g2 where g2.friendId = ?1 and g2.groupId = g.id and g.ownerId != ?2";

		String sql = "select g.id, g.category, g.group_name, g.ispublic, g.owner_id from groups "
				+ "g, group_friend_id g2 where g2.friend_id = ?1 and g2.group_id = g.id and g.owner_id != ?2";

		List<Group> g = null;
		GroupFriend gf = new GroupFriend(user, group);

		try {
			g = entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, gf.getFriendId())
					.setParameter(2, gf.getFriendId()).getResultList();
			// g = entityManager.createQuery(sql2).
			// setParameter(1, user.getId()).setParameter(2,
			// user.getId()).getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return g;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getFriendsInGroup(Integer group) {

		List<User> friends = null;
		String sql = "select distinct(u)"
				+ " from User u, GroupFriend gf where"
				+ " gf.groupId = ?1 and gf.friendId = u.id ";

		friends = entityManager.createQuery(sql).setParameter(1, group)
				.getResultList();
		// select distinct(u) from users u,
		// groups g, group_friend_id gf
		// where ( gf.group_id = 1000 and gf.friend_id = u.id);
		// Projections.distinct(Projections.property(propertyName))

		return friends;
	}

	@Override
	@Transactional
	public GroupFriend unfriend(Integer g, Integer u) {

		String sql = "DELETE FROM GroupFriend WHERE groupId = ?1 and friendId = ?2";

		String sql2 = "delete from group_friend_id where group_id = ?1 and friend_id = ?2 ";
		entityManager.createNativeQuery(sql2).setParameter(1, g)
				.setParameter(2, u).executeUpdate();

		// createQuery(sql).setParameter(1, g).setParameter(2,
		// u).getFirstResult();
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getOwnerGroups(User user) {
		List<Group> groups = null;

		String sql = "select * from groups  where owner_id = ?1";

		try {
			groups = entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, user.getId()).getResultList();
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return groups;
	}

	@Override
	public boolean isInGroup(Integer gId, Integer uId) {

		boolean isInGroup = false;
		Group g = null;
		String sql = "select g.id, g.category, g.group_name,g.ispublic, g.owner_id  from groups g, group_friend_id gf  "
				+ " where g.id = ?1 and gf.group_id = ?2 and gf.friend_id = ?3";

		try {
			g = (Group) entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, gId).setParameter(2, gId).setParameter(3, uId)
					.getSingleResult();

		} catch (EmptyResultDataAccessException e) {
			return false;
		} catch (NoResultException noE) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> getAllPriv(boolean value) {
		List<Group> groups = null;
		String sql = "SELECT * FROM groups WHERE ispublic = ?1";
		try {
			groups = entityManager.createNativeQuery(sql, Group.class)
					.setParameter(1, value).getResultList();

		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return groups;
	}

	@Override
	public List<Group> getGroupsIamInPriv(User user) {
		List<Group> groups = null;
		String sql = "select distinct( g ) from Group g, Notifications n" +
				" where n.groudId = g.id and n.friendId = ?1 ";
		try {
			groups = entityManager.createQuery(sql, Group.class)
					.setParameter(1, user).getResultList();

		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (NoResultException noE) {
			return null;
		}

		return groups;
	}

}
