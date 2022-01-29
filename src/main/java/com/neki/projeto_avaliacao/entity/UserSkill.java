package com.neki.projeto_avaliacao.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "user_skill")
public class UserSkill {

	@Id
	@ApiModelProperty(value = "Identificado único da Skill")
	@GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ApiModelProperty(value = "Relacionamento de tabelas via ID do usuário")
	@NotNull(message = "O id do usuário relacionado deverá ser associado")
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;
	
	@ApiModelProperty(value = "Relacionamento de tabelas via ID da Skill")
	@NotNull(message = "O id da habilidade relacionada deverá ser associada")
	@ManyToOne
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	private Skill skillId;

	@ApiModelProperty(value = "Nível de conhecimento a ser avaliado com valores de 1 a 10")
	@NotNull(message = "O nível de conhecimento deverá ser informado, avaliação de 1 a 10")
	@Column (name = "knowledge_level", nullable= false )	
	private Integer Knowledge;
	
	@ApiModelProperty(value = "Data da Criação")
	@NotNull(message = "Data de criação deverá ser informada")
	@Column (name = "created_at", nullable= false )	
	private LocalDate dateCreated;
	
	@ApiModelProperty(value = "Data da Alteração")
	@NotNull(message = "Data da atualização deverá ser informada")
	@Column (name = "updated_at", nullable= false )	
	private LocalDate dateUpdate;
	
	public UserSkill() {
		super();
	}

	public UserSkill(Long id,
			@NotNull(message = "O nível de conhecimento deverá ser informado, avaliação de 1 a 10") Integer knowledge,
			@NotNull(message = "Data de criação deverá ser informada") LocalDate dateCreated,
			@NotNull(message = "Data da atualização deverá ser informada") LocalDate dateUpdate,
			@NotNull(message = "O id do usuário relacionado deverá ser associado") User userId,
			@NotNull(message = "O id da habilidade relacionada deverá ser associada") Skill skillId) {
		super();
		this.id = id;
		Knowledge = knowledge;
		this.dateCreated = dateCreated;
		this.dateUpdate = dateUpdate;
		this.userId = userId;
		this.skillId = skillId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(Knowledge, dateCreated, dateUpdate, id, skillId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSkill other = (UserSkill) obj;
		return Objects.equals(Knowledge, other.Knowledge) && Objects.equals(dateCreated, other.dateCreated)
				&& Objects.equals(dateUpdate, other.dateUpdate) && Objects.equals(id, other.id)
				&& Objects.equals(skillId, other.skillId) && Objects.equals(userId, other.userId);
	}
	
}
