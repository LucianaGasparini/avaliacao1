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

import com.neki.projeto_avaliacao.VO.SkillAdd;
import com.neki.projeto_avaliacao.VO.SkillDisplay;
import com.neki.projeto_avaliacao.service.SkillService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping ("/skills")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	

	// Listar todos
	@GetMapping	
	@ApiOperation(value = "Listar Habilidades ", notes = "Listar Habilidades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidades listadas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<List<SkillDisplay>> listAll() {
		List<SkillDisplay> listFile = skillService.searchAll();
		return ResponseEntity.ok(listFile);
	}
	
	// inserir
	@PostMapping
	@ApiOperation(value = "Inserir habilidade", notes = "Inserir habilidade")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade inserida com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<Object> addSkill (@Valid @RequestBody SkillAdd skillAdd){
		SkillDisplay skillDisplay = skillService.addSkill(skillAdd);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(skillDisplay.getId()).toUri();
		return ResponseEntity.created(uri).body(skillAdd);
	}
	
	// Buscar por id
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar habilidade por ID", notes = "Buscar habilidade por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade encontrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<SkillDisplay> listId(@PathVariable Long id){
		SkillDisplay skill = skillService.search(id);
		if(null != skill) {
			return ResponseEntity.ok(skill);
		}
		return ResponseEntity.notFound().build();
	}
	
	// Atualizar
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualizar habilidade por ID", notes = "Atualizar habilidade por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade atualizada com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		public ResponseEntity<SkillDisplay> atualizar(@PathVariable Long id,
				@RequestBody SkillAdd skillAdd) {
			SkillDisplay skillDisplay =skillService.update(id, skillAdd);
			if (skillDisplay == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(skillDisplay);
		}
	
	

	// Deletar
		@DeleteMapping("/{id}")
		@ApiOperation(value = "Excluir habilidade por ID", notes = "Excluir habilidade por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade excluída com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			if(!skillService.delete(id)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.noContent().build();
		}
	
	
}
