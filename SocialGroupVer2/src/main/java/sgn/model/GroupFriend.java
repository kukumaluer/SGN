package sgn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_friend_id")
public class GroupFriend {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@Column(name = "friend_id")
	public Integer friendId;
	
	
	@Column(name = "group_Id ")
	public Integer groupId;

	
	
	
	public GroupFriend() {
		super();
	}

	public GroupFriend(Integer id, User friendId, Group groupId) {
		super();
		this.id = id;
		this.friendId = friendId.getId();
		this.groupId = groupId.getId();
	}

	public GroupFriend(User friendId, Group groupId) {
		super();
		this.friendId = friendId.getId();
		this.groupId = groupId.getId();
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(User friendId) {
		this.friendId = friendId.getId();
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Group groupId) {
		this.groupId = groupId.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
