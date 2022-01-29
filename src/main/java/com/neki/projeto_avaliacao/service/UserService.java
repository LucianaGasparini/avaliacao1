package com.neki.projeto_avaliacao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.neki.projeto_avaliacao.VO.UserAdd;
import com.neki.projeto_avaliacao.VO.UserDisplay;
import com.neki.projeto_avaliacao.entity.User;
import com.neki.projeto_avaliacao.repository.UserRepository;

public class UserService {
	
	@Autowired	
	UserRepository userRepository;
	
	// Service Listar todos 	
	public List<UserDisplay> searchAll() {
		List<UserDisplay> usersDisplay = new ArrayList<UserDisplay>();
		List<User> users = userRepository.findAll();

		for (User user : users) {
			
			UserDisplay userDisplay =  new UserDisplay();
			userDisplay.setId(user.getId());		
			userDisplay.setLastDateLogin(user.getLastDateLogin());
			userDisplay.setLogin(user.getLogin());
			userDisplay.setPassword(user.getPassword());
						usersDisplay.add(userDisplay);
			
	}
	
	return usersDisplay;
	}
	
	// Service inserir
	public UserDisplay addUser(UserAdd userAdd) {
		User user = new User();
		user.setLastDateLogin(userAdd.getLastDateLogin());
		user.setLogin(userAdd.getLogin());
		user.setPassword(userAdd.getPassword());
		
		
		return new UserDisplay (user);
	}
	
	// Buscar por ID
		public UserDisplay search(Long id) {
			Optional<User> user = userRepository.findById(id);
			if (!user.isPresent()) {
				return null;
			}
			return new UserDisplay(user.get());
		}
		
		// Atualizar
				public UserDisplay update(Long id, UserAdd userAdd) {
					User user = new User();
					if (!userRepository.existsById(id)) {
						return null;
					}
					user.setId(id);
					user.setLastDateLogin(userAdd.getLastDateLogin());
					user.setLogin(userAdd.getLogin());
					user.setPassword(userAdd.getPassword());
				
					return new UserDisplay(user);
				}
	
		// Service deletar
		@Transactional
		public boolean delete(Long id) {
			
			if (!userRepository.existsById(id)) {
				return false;
			
			}
			userRepository.deleteById(id);
			return true;
		}
		
}


