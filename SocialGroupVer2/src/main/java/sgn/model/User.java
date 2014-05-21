package sgn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name ="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@DiscriminatorValue("ROLE_USER")
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	

	
	@Column(name = "password")
	private String password;

	@Column(name= "email")
	private String email;
	
	@Column(nullable = false)
	private boolean enabled;
	
	
	@OneToMany(mappedBy = "ownerId",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Group> groups;
	
	
	
	
	public User()
	{
		super();
		enabled = true;
		this.groups = new ArrayList<Group>();
	
	}


	public User(Integer id, String firstName, String lastName,
			String password, boolean enabled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.password = password;
		this.enabled = enabled;
		this.groups = new ArrayList<Group>();
	
		
	}

	

	public User(Integer id, String firstName, String lastName,
			String password, String email, boolean enabled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.groups = new ArrayList<Group>();
	
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Group> getGroups() {
		return groups;
	}


	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public void addGroup(Group group)
	{
		this.groups.add(group);
	}
	public void deleteGroup(Group group)
	{
		this.groups.remove(group);
		
	}

	
}
