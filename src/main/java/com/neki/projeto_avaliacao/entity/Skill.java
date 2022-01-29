package com.neki.projeto_avaliacao.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "skill")
public class Skill {
	
	@Id
	@ApiModelProperty(value = "Identificado único da Skill")
	@GeneratedValue(generator = "id", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ApiModelProperty(value = "Nome até 100 caracteres")
	@NotNull( message = "O nome da habilidade deverá ser preenchida" )
	@Column (name = "name", length = 100, nullable = false )	
	private String name;
	
	@ApiModelProperty(value = "Versão até 10 caracteres")
	@Column (name = "version", length = 10, nullable = true)	
	private String version;
	
	@ApiModelProperty(value = "Descrição até 255 caracteres")
	@NotNull( message = "A descrição da Habilidade deverá ser preenchida" )
	@Column (name = "description", length = 255, nullable = false )	
	private String description;
	
	@ApiModelProperty(value = "Imagem até 255 caracteres de URL")
	@Column (name = "image_url", length = 255, nullable= true )	
	private String image;


	public Skill() {
		super();
	}


	public Skill(Long id, @NotNull(message = "O nome da habilidade deverá ser preenchida") String name, String version,
			@NotNull(message = "A descrição da Habilidade deverá ser preenchida") String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.image = image;
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


	@Override
	public int hashCode() {
		return Objects.hash(description, id, image, name, version);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(name, other.name)
				&& Objects.equals(version, other.version);
	}
	
	
}
