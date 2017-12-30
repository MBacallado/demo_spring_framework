package com.mbacallado.springFramework.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mbacallado.springFramework.entity.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Serializable> {
	
	@Query(value="SELECT * FROM roles WHERE role_id = ?1", nativeQuery=true)
	public Role findById(int roleId);
}
