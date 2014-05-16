package sgn.model.dao.jap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sgn.model.Comment;
import sgn.model.dao.CommentDao;

public class CommentDaoImpl implements CommentDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Comment getComments(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getComment(Integer id) {
		
//		select * from comments c 
//		left join groups_users g 
//		on c.post_by = g.groupFriends_id 
//		and g.groups_id = 1 ;
		return null;
	}

}
