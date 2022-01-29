package com.neki.projeto_avaliacao.VO;

import com.neki.projeto_avaliacao.entity.Skill;

public class SkillAdd {
	
	private String name;
	private String version;
	private String description;
	private String image;
	public SkillAdd() {
		super();
	}


	public SkillAdd(Skill skill) {
		super();
		this.name = skill.getName();
		this.version = skill.getVersion();
		this.description = skill.getDescription();
		this.image = skill.getImage();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	
}
