package com.neki.projeto_avaliacao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.neki.projeto_avaliacao.VO.UserSkillAdd;
import com.neki.projeto_avaliacao.VO.UserSkillDisplay;
import com.neki.projeto_avaliacao.entity.UserSkill;
import com.neki.projeto_avaliacao.repository.UserSkillRepository;

public class UserSkillService {
	@Autowired	
	UserSkillRepository userSkillRepository;
	
	// Service Listar todos 	
	public List<UserSkillDisplay> searchAll() {
		List<UserSkillDisplay> userSkillsDisplay = new ArrayList<UserSkillDisplay>();
		List<UserSkill> usersSkill = userSkillRepository.findAll();

		for (UserSkill userSkill : usersSkill) {
			
			UserSkillDisplay userSkillDisplay =  new UserSkillDisplay();
			userSkillDisplay.setDateCreated(userSkill.getDateCreated());
			userSkillDisplay.setDateUpdate(userSkill.getDateUpdate());
			userSkillDisplay.setId(userSkill.getId());
			userSkillDisplay.setKnowledge(userSkill.getKnowledge());
			userSkillDisplay.setSkillId(userSkill.getSkillId());
			userSkillDisplay.setUserId(userSkill.getUserId());
			
			 userSkillsDisplay.add(userSkillDisplay);
			
	}
	
	return  userSkillsDisplay;
	}
	
	// Service inserir
	public UserSkillDisplay addUserSkill(UserSkillAdd userSkillAdd) {
		UserSkill userSkill = new UserSkill();
		userSkill.setDateCreated(userSkillAdd.getDateCreated());
		userSkill.setDateUpdate(userSkillAdd.getDateUpdate());
		userSkill.setKnowledge(userSkillAdd.getKnowledge());
		userSkill.setSkillId(userSkillAdd.getSkillId());
		userSkill.setUserId(userSkillAdd.getUserId());
		
		return new  UserSkillDisplay (userSkill);
	}
	
	// Buscar por ID
		public UserSkillDisplay search(Long id) {
			Optional<UserSkill> userSkill = userSkillRepository.findById(id);
			if (!userSkill.isPresent()) {
				return null;
			}
			return new UserSkillDisplay(userSkill.get());
		}
		
		// Atualizar
		public UserSkillDisplay update(Long id, UserSkillAdd userSkillAdd) {
			UserSkill userSkill = new UserSkill();
			if (!userSkillRepository.existsById(id)) {
				return null;
			}
			userSkill.setId(id);
			userSkill.setDateCreated(userSkillAdd.getDateCreated());
			userSkill.setDateUpdate(userSkillAdd.getDateUpdate());
			userSkill.setKnowledge(userSkillAdd.getKnowledge());
			userSkill.setSkillId(userSkillAdd.getSkillId());
			userSkill.setUserId(userSkillAdd.getUserId());
			return new UserSkillDisplay(userSkill);
		}
		
	
		// Service deletar
		@Transactional
		public boolean delete(Long id) {
			
			if (!userSkillRepository.existsById(id)) {
				return false;
			
			}
			userSkillRepository.deleteById(id);
			return true;
		}
		
}
