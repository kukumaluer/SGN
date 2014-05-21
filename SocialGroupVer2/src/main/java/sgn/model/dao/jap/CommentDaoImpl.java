package sgn.model.dao.jap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sgn.model.Comment;
import sgn.model.dao.CommentDao;

@Repository
public class CommentDaoImpl implements CommentDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Comment getComments(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getComment(Integer id) {
		
		List<Comment> comments = null;
		String sql = "SELECT * from comments c where c.group_id = ?1" ;
				
		
		try{
			comments = entityManager.createNativeQuery(sql, Comment.class)
					.setParameter(1, id).getResultList();

		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		catch(NoResultException e)
		{
			return null;
		}
		
		
		 
//		select * from comments c 
//		left join groups_users g 
//		on c.post_by = g.groupFriends_id 
//		and g.groups_id = 1 ;
		return comments;
	}

	@Override
	@Transactional
	public Comment saveComment(Comment comment) {
		// TODO Auto-generated method stub
		return entityManager.merge(comment);
	}

}
