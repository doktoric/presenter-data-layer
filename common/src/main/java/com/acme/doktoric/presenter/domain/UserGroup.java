package com.acme.doktoric.presenter.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usergroup")
public class UserGroup {

	@Id
	@GeneratedValue
	private long id;
	@ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Presentation> presentations=new HashSet<Presentation>();
	@ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<User> users=new HashSet<User>();
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private Set<User> blockedUsers=new HashSet<User>();
	private String name;
	private Date creatDate;
	private Date lastModifyDate;
	
	
	
	public UserGroup() {
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Set<Presentation> getPresentations() {
		return presentations;
	}



	public void setPresentations(Set<Presentation> presentations) {
		this.presentations = presentations;
	}



	public Set<User> getUsers() {
		return users;
	}



	public void setUsers(Set<User> users) {
		this.users = users;
	}



	public Set<User> getBlockedUsers() {
		return blockedUsers;
	}



	public void setBlockedUsers(Set<User> blockedUsers) {
		this.blockedUsers = blockedUsers;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getCreatDate() {
		return creatDate;
	}



	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}



	public Date getLastModifyDate() {
		return lastModifyDate;
	}



	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	
	
	 
	 
	
}
