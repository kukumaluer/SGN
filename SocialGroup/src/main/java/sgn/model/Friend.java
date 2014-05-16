package sgn.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("ROLE_FRIEND")
public class Friend extends User{


	
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Friend(Integer id, String firstName, String lastName,
			String userName, String password, boolean enabled) {
		super(id, firstName, lastName, userName, password, enabled);
		// TODO Auto-generated constructor stub
	}

	public Friend(Integer id, String firstName, String lastName,
			String userName, String password, String email, boolean enabled) {
		super(id, firstName, lastName, userName, password, email, enabled);
		// TODO Auto-generated constructor stub
	}


	
	
}
