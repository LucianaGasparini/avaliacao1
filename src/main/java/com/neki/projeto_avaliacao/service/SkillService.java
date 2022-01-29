package com.neki.projeto_avaliacao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.projeto_avaliacao.VO.SkillAdd;
import com.neki.projeto_avaliacao.VO.SkillDisplay;
import com.neki.projeto_avaliacao.entity.Skill;
import com.neki.projeto_avaliacao.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired	
	SkillRepository skillRepository;
	
	// Service Listar todos 	
	public List<SkillDisplay> searchAll() {
		List<SkillDisplay> skillsDisplay = new ArrayList<SkillDisplay>();
		List<Skill> skills = skillRepository.findAll();

		for (Skill skill : skills) {
			
			SkillDisplay skillDisplay =  new SkillDisplay();
			skillDisplay.setId(skill.getId());
			skillDisplay.setName(skill.getName());
			skillDisplay.setDescription(skill.getDescription());
			skillDisplay.setVersion(skill.getVersion());
			skillDisplay.setImage(skill.getImage());
			
			skillsDisplay.add(skillDisplay);
			
	}
	
	return skillsDisplay;
	}
	
	// Service inserir
	public SkillDisplay addSkill(SkillAdd skillAdd) {
		Skill skill = new Skill();
		skill.setName(skillAdd.getName());
		skill.setDescription(skillAdd.getDescription());
		skill.setVersion(skillAdd.getVersion());
		skill.setImage(skill.getImage());
		
		return new SkillDisplay (skill);
		
	}
	
	// Buscar por ID
		public SkillDisplay search(Long id) {
			Optional<Skill> skill = skillRepository.findById(id);
			if (!skill.isPresent()) {
				return null;
			}
			return new SkillDisplay(skill.get());
		}
		
		// Atualizar
		public SkillDisplay update(Long id, SkillAdd skillAdd) {
			Skill skill = new Skill();
			if (!skillRepository.existsById(id)) {
				return null;
			}
			skill.setId(id);
			skill.setDescription(skillAdd.getDescription());
			skill.setName(skillAdd.getName());
			skill.setVersion(skillAdd.getVersion());
			skill.setImage(skillAdd.getImage());
			return new SkillDisplay(skill);
		}
		
			
		// Service deletar
		@Transactional
		public boolean delete(Long id) {
			
			if (!skillRepository.existsById(id)) {
				return false;
			
			}
			skillRepository.deleteById(id);
			return true;
		}
		
}
