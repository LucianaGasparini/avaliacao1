package com.neki.projeto_avaliacao.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.neki.projeto_avaliacao.VO.UserSkillAdd;
import com.neki.projeto_avaliacao.VO.UserSkillDisplay;
import com.neki.projeto_avaliacao.service.UserSkillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("/userSkills")
public class UserSkillController {
	
	@Autowired
	UserSkillService userSkillService;
	

	// Listar todos
	@GetMapping	
	@ApiOperation(value = "Listar Habilidades do Usuário ", notes = "Listar Habilidades do Usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Habilidades do Usuário listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<List<UserSkillDisplay>> listAll() {
		List<UserSkillDisplay> listFile = userSkillService.searchAll();
		return ResponseEntity.ok(listFile);
	}
	
	// inserir
	@PostMapping
	@ApiOperation(value = "Inserir Habilidades do Usuário ", notes = "Inserir Habilidades do Usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Habilidades do Usuário inseridas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<Object> addUserSkill (@Valid @RequestBody UserSkillAdd userSkillAdd){
		UserSkillDisplay userSkillDisplay = userSkillService.addUserSkill(userSkillAdd);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userSkillDisplay.getId()).toUri();
		return ResponseEntity.created(uri).body(userSkillAdd);
	}
	
	// Buscar por id
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar habilidade usuário por ID", notes = "Buscar habilidado do usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<UserSkillDisplay> listId(@PathVariable Long id){
		UserSkillDisplay userSkill = userSkillService.search(id);
		if(null != userSkill) {
			return ResponseEntity.ok(userSkill);
		}
		return ResponseEntity.notFound().build();
	}
	
	// Atualizar
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualizar habilidade usuário por ID", notes = "Atualizar habilidado do usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário atualizada com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		public ResponseEntity<UserSkillDisplay> atualizar(@PathVariable Long id,
				@RequestBody UserSkillAdd userSkillAdd) {
			UserSkillDisplay userSkillDisplay =userSkillService.update(id, userSkillAdd);
			if (userSkillDisplay == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(userSkillDisplay);
		}
	
	

	// Deletar
		@DeleteMapping("/{id}")
		@ApiOperation(value = "Excluirr habilidade usuário por ID", notes = "Excluir habilidado do usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário excluída com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			if(!userSkillService.delete(id)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.noContent().build();
		}
	
}
