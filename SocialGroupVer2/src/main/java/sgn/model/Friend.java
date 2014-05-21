package sgn.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Friend extends User{


	
	
	
	public Group groupfriend;
	
	
	public Friend(Group groupfriend) {
		super();
		this.groupfriend = groupfriend;
	}

	
	
	public Friend(Integer id, String firstName, String lastName,
			String password, boolean enabled) {
		super(id, firstName, lastName, password, enabled);
		// TODO Auto-generated constructor stub
	}
	public Friend(Group g, Integer id, String firstName, String lastName,
			String password, boolean enabled) {
		super(id, firstName, lastName, password, enabled);
		this.groupfriend = g;
		// TODO Auto-generated constructor stub
	}

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Friend(Integer id, String firstName, String lastName,
			String userName, String password, boolean enabled) {
		super(id, firstName, lastName, userName, password, enabled);
		// TODO Auto-generated constructor stub
	}



	public Group getgroupfriend() {
		return groupfriend;
	}



	public void setgroupfriend(Group groupfriend) {
		this.groupfriend = groupfriend;
	}

//	public Friend(Integer id, String firstName, String lastName,
//			String userName, String password, boolean enabled) {
//		super(id, firstName, lastName, userName, password, enabled);
//		// TODO Auto-generated constructor stub
//	}


	
	
}
