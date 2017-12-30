package com.mbacallado.springFramework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role_name")
	private String role;
	
	public Role() {
		
	}
	
	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
