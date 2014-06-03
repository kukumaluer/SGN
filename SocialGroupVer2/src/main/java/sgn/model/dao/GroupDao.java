package sgn.model.dao;

import java.util.List;

import sgn.model.Group;
import sgn.model.GroupFriend;
import sgn.model.User;

public interface GroupDao {
	
	Group getGroupById(Integer id);
	Group saveGroup(Group group);
	List<Group> getAll(boolean value);
	List<Group> getAll(User user);
	List<Group> getAllPriv(boolean value);
	List<Group> getUserGroup(User user);
	List<Integer> inGroup(Integer id);
	List<Group> getAllExceptinGroup(User user);
	List<Group> getAllInGroup(User user);
	List<Group> getGroupsIamIn(Group group, User user);
	List<Group> getGroupsIamInPriv(User user);
	List<User> getFriendsInGroup(Integer group);
	List<Group> getOwnerGroups(User user);
	String getCategory(String category);
	boolean getIsPublic(Integer id);
	boolean isInGroup(Integer gId, Integer uId);
	GroupFriend unfriend(Integer g, Integer u);
	
	
	

}
