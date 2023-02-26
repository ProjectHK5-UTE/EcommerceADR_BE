package com.ecomerce.android.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.android.model.User;
import com.ecomerce.android.responsitory.UserRepository;
import com.ecomerce.android.service.UserService;





@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	public <S extends User> boolean save(S entity) {
		return userRepository.save(entity) != null;
	}

	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	public boolean checkLogin(User user) {
		List<User> listUser = userRepository.findAll();
		for (User userExist : listUser) {
			if (StringUtils.equals(user.getEmail(), userExist.getEmail())
					&& StringUtils.equals(user.getPassword(), userExist.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public void delete(User entity) {
		userRepository.delete(entity);
	}
	
	public Optional<User> loadUserByEmail(String email) { 
		return userRepository.getByEmail(email);
	}

	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
