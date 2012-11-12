package com.acme.doktoric.presenter.dao;

import com.acme.doktoric.presenter.domain.User;

public class UserDAO extends AbstractJpaDAO<User> implements IUserDAO {

	
	
	public UserDAO() {
		setClazz(User.class);
	}
	
	
}
