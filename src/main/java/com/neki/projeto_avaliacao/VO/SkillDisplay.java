package com.neki.projeto_avaliacao.VO;

import com.neki.projeto_avaliacao.entity.Skill;

public class SkillDisplay {
	private Long id;
	private String name;
	private String version;
	private String description;
	private String image;
	
	
	
	public SkillDisplay() {
		super();
	}

	public SkillDisplay(Skill skill) {
		super();
		this.id = skill.getId();
		this.name = skill.getName();
		this.version = skill.getVersion();
		this.description = skill.getDescription();
		this.image = skill.getImage();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
