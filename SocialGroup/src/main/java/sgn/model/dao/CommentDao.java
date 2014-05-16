package sgn.model.dao;

import java.util.List;

import sgn.model.Comment;

public interface CommentDao {
	
	Comment getComments(Integer id);
	List<Comment> getComment(Integer id);
	
}
