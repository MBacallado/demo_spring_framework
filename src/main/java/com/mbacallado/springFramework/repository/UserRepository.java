package com.mbacallado.springFramework.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mbacallado.springFramework.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
	
	@Query(value = "SELECT u from User u WHERE u.user = ?1 and u.password = ?2", nativeQuery = true)
	public User findUserByUsernameAndPassword(String username, String password);
}
