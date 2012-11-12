package com.acme.doktoric.presenter.dao;

import com.acme.doktoric.presenter.domain.Presentation;

public class PresentationDAO extends AbstractJpaDAO<Presentation> implements IPresentationDAO{

	


	public PresentationDAO() {
		setClazz(Presentation.class);
	}

	
}
