package com.acme.doktoric.presenter.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.doktoric.presenter.dao.IGroupDAO;
import com.acme.doktoric.presenter.dao.IPresentationDAO;
import com.acme.doktoric.presenter.dao.IUserDAO;

public abstract class AbstractService implements IAbstractService  {

	@Autowired
	IUserDAO userDao;
	@Autowired
	IPresentationDAO presentationDao;
	@Autowired
	IGroupDAO groupDao;
	
	
	
	

	
}
