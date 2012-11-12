package com.acme.doktoric.presenter.dao;

import org.springframework.stereotype.Repository;

import com.acme.doktoric.presenter.domain.UserGroup;

@Repository
public class GroupDAO extends AbstractJpaDAO<UserGroup> implements IGroupDAO {


	
	
	public GroupDAO() {
		setClazz(UserGroup.class);
	}

}
