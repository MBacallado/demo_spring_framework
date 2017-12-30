package com.mbacallado.springFramework.services.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbacallado.springFramework.entity.Role;
import com.mbacallado.springFramework.entity.User;
import com.mbacallado.springFramework.repository.RoleRepository;
import com.mbacallado.springFramework.repository.UserRepository;

@Service("loginService")
public class LoginServiceImpl implements UserDetailsService {

	private static final Log LOG = LogFactory.getLog(LoginServiceImpl.class);
	private static final String TAG = LoginServiceImpl.class.getSimpleName();
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("roleRepository")
	private RoleRepository roleRepository;

	/**
	 * Method that creates and returns an UserDetails from username
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		Role role = roleRepository.findById(user.getRoleId());
		List<GrantedAuthority> auths = buildAuths(role);
		return buildUser(user, auths);
	}

	/**
	 * Method that creates and returns a new User with the username, password and roles
	 * @param user
	 * @param auths
	 * @return
	 */
	private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> auths) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auths);
	}
	
	/**
	 * Method that creates and returns an ArrayList with the roles converted to GrandtedAuthorities
	 * @param role
	 * @return
	 */
	private List<GrantedAuthority> buildAuths(Role role) {
		Set<GrantedAuthority> auth = new HashSet<GrantedAuthority>();
		LOG.info(TAG + ":" + role.getRole());
		auth.add(new SimpleGrantedAuthority(role.getRole()));
		return new ArrayList<GrantedAuthority>(auth);
	}

}
