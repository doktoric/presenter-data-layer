package com.acme.doktoric.presenter.domain;

import javax.persistence.Entity;

@Entity
public enum UserRole {
	ADMIN,USER,VIEWER;
}
