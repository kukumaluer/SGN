package sgn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "notifications")
public class Notifications implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="notify_user_id")
	private User notified;
	
	@ManyToOne
	@JoinColumn(name = "adding_group_id")
	private Group groudId;
	
	@ManyToOne
	@JoinColumn(name = "friend_to_add_id")
	private User friendId;
	

	
	public Notifications(Integer id, User notified, Group groudId, User friendId) {
		super();
		this.id = id;
		this.notified = notified;
		this.groudId = groudId;
		this.friendId = friendId;
	}

	
	public Notifications(User notified, Group groudId, User friendId) {
		super();
		this.notified = notified;
		this.groudId = groudId;
		this.friendId = friendId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setGroudId(Group groudId) {
		this.groudId = groudId;
	}

	public void setFriendId(User friendId) {
		this.friendId = friendId;
	}

	public Notifications() {
		super();
	}
	
	public User getNotified() {
		return notified;
	}


	public void setNotified(User notified) {
		this.notified = notified;
	}


	public Group getGroudId() {
		return groudId;
	}


	public User getFriendId() {
		return friendId;
	}


	//	public Notifications(Integer groudId, Integer friendId) {
//		super();
//		this.groudId = groudId;
//		this.friendId = friendId;
//	}
//
//	public Notifications(User user, Integer groudId, Integer friendId) {
//		super();
//		this.notified = user;
//		this.groudId = groudId;
//		this.friendId = friendId;
//	}
//	public User getNotified() {
//		return notified;
//	}
//	public void setNotified(User user) {
//		this.notified = user;
//	}
//	public Integer getGroudId() {
//		return groudId;
//	}
//	public void setGroudId(Integer groudId) {
//		this.groudId = groudId;
//	}
//	public Integer getFriendId() {
//		return friendId;
//	}
//	public void setFriendId(Integer friendId) {
//		this.friendId = friendId;
//	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
