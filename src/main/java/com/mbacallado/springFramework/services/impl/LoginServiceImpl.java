package com.mbacallado.springFramework.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mbacallado.springFramework.entity.User;
import com.mbacallado.springFramework.repository.UserRepository;
import com.mbacallado.springFramework.services.LoginService;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	private static final Log LOG = LogFactory.getLog(LoginServiceImpl.class);
	private static final String TAG = LoginServiceImpl.class.getSimpleName();
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	/**
	 * Method that checks the credentials and returns true or false
	 */
	@Override
	public boolean checkUser(User user) {
		LOG.info("call: " + TAG + " --checkUser");
		User userDb = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		return (userDb != null) ? true : false;
	}

}
