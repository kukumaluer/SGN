package sgn.model.dao;

import sgn.model.User;

public interface UserDao {
	User getUserById(Integer id);
	User saveUser(User user);
	User getUser(User user);
	User getUser(Integer id);
	User getUser(String username);
	User getUser(String email, String password);
	boolean hasAccount(String email);
}
