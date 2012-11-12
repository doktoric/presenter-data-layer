package com.acme.doktoric.presenter.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="presentation")
public class Presentation {

	@Id
	@GeneratedValue
	private long id;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "presentations", joinColumns = { @JoinColumn(name = "presentation_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") })
	Set<UserGroup> groups=new HashSet<UserGroup>();
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	Set<User> blockedUsers=new HashSet<User>();
	private String name;
	private Date creatDate;
	private Date lastModifyDate;
	@OneToOne
	private User lastModifiedUser;
	private Date finishedDate;
	private UserRole role;
	
	public Presentation() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<UserGroup> groups) {
		this.groups = groups;
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

	public User getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(User lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}
	
	
	
	
	
}
