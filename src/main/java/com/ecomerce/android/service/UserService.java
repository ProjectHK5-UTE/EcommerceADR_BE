package com.ecomerce.android.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ecomerce.android.model.User;


public interface UserService{

	void delete(User entity);

	public boolean checkLogin(User user);

	Optional<User> findById(Integer id);

	public <S extends User> boolean save(S entity); 
	
	Optional<User> loadUserByEmail(String email);
	
	public void deleteById(Integer id);
	
	public List<User> findAll();
	
}
