package sgn.model.dao;

import java.util.List;

import sgn.model.Group;
import sgn.model.User;

public interface GroupDao {
	
	Group getGroupById(Integer id);
	Group saveGroup(Group group);
	List<Group> getAll();
	List<Group> getAll(User user);
	List<Group> getUserGroup(User user);
	List<Integer> inGroup(Integer id);
	List<Group> getAllExceptinGroup(User user);
	List<Group> getAllInGroup(User user);
	List<Group> getGroupsIamIn(Group group, User user);
	List<User> getFriendsInGroup(Integer group);
	String getCategory(String category);
	boolean getIsPublic(Integer id);
	void unfriend(Integer g, Integer u);
	
	
	

}
