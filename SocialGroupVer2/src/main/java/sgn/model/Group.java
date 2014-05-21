package sgn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name = "groups")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "group_name")
	private String groupName;
	
	
	private String category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private User ownerId;
	
	
	@OneToMany( cascade  = {CascadeType.PERSIST, CascadeType.MERGE} )
	private List<User> Users;
	
	
	@OneToMany(mappedBy = "groupId",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@OrderBy("createdOn asc")
	private List<Comment> commets;
	
	private boolean isPublic;
	
	
	public Group()
	{
		super();
		this.Users = new ArrayList<User>();
		this.commets = new ArrayList<Comment>();
		
	}
	
	


	public Group(Integer id, String groupName, User ownerId) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.ownerId = ownerId;
		this.Users = new ArrayList<User>();
		this.commets = new ArrayList<Comment>();
		this.isPublic = true;
	}

	
	public Group(Integer id, String groupName, String category){
		super();
		this.id = id;
		this.groupName = groupName;
		this.category = category;
		this.Users = new ArrayList<User>();
		this.commets = new ArrayList<Comment>();
		this.isPublic = true;
	}
	public Group(Integer id, String groupName, String category, User ownerId){
		super();
		this.id = id;
		this.groupName = groupName;
		this.category = category;
		this.Users = new ArrayList<User>();
		this.commets = new ArrayList<Comment>();
		this.ownerId = ownerId;
		this.isPublic = true;
	}



	public Group(Integer id, String groupName, String category, User ownerId,
			boolean isPublic) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.category = category;
		this.ownerId = ownerId;
		this.isPublic = isPublic;
		this.Users = new ArrayList<User>();
		this.commets = new ArrayList<Comment>();
		
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public boolean isPublic() {
		return isPublic;
	}

	public boolean getIsPublic()
	{
		return isPublic();
	}
	public void setIsPublic(boolean isPublic)
	{
		this.isPublic = isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public User getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(User ownerId) {
		this.ownerId = ownerId;
	}


	public List<User> getUsers() {
		return Users;
	}


	public void setUsers(List<User> Users) {
		this.Users = Users;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<Comment> getCommets() {
		return commets;
	}

	public void setCommets(List<Comment> commets) {
		this.commets = commets;
	}
	
	

}
