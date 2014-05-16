package sgn.model.dao;

import java.util.List;

import sgn.model.Group;
import sgn.model.User;

public interface GroupDao {
	
	Group getGroupById(Integer id);
	String getCategory(String category);
	boolean getIsPublic(Integer id);
	List<Group> getAll();
	List<Group> getAll(User user);
	List<Group> getUserGroup(User user);
	Group saveGroup(Group group);
	

}
