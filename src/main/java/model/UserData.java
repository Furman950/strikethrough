package model;

import java.io.Serializable;
import java.util.*;

public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

    private List<User> users = new ArrayList<>();

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param user the users to set
	 */
	public void setUsers(User user) {
		this.users.add(user);
	}
}
