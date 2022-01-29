package com.neki.projeto_avaliacao.VO;

import java.time.LocalDate;

import com.neki.projeto_avaliacao.entity.Skill;
import com.neki.projeto_avaliacao.entity.User;
import com.neki.projeto_avaliacao.entity.UserSkill;

public class UserSkillAdd {
	private Integer Knowledge;
	private LocalDate dateCreated;
	private LocalDate dateUpdate;
	private User userId;
	private Skill skillId;
	
	
	public UserSkillAdd(UserSkill userSkill) {
		super();
		Knowledge = userSkill.getKnowledge();
		this.dateCreated = userSkill.getDateCreated();		
		this.dateUpdate = userSkill.getDateUpdate();
		this.userId = userSkill.getUserId();
		this.skillId = userSkill.getSkillId();
	}


	public Integer getKnowledge() {
		return Knowledge;
	}


	public void setKnowledge(Integer knowledge) {
		Knowledge = knowledge;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	public LocalDate getDateUpdate() {
		return dateUpdate;
	}


	public void setDateUpdate(LocalDate dateUpdate) {
		this.dateUpdate = dateUpdate;
	}


	public User getUserId() {
		return userId;
	}


	public void setUserId(User userId) {
		this.userId = userId;
	}


	public Skill getSkillId() {
		return skillId;
	}


	public void setSkillId(Skill skillId) {
		this.skillId = skillId;
	}


}
