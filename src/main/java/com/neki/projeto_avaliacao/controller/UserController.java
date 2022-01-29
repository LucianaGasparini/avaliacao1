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



import com.neki.projeto_avaliacao.VO.UserAdd;
import com.neki.projeto_avaliacao.VO.UserDisplay;

import com.neki.projeto_avaliacao.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("/users")
public class UserController {
	@Autowired
	UserService userService;
	

	// Listar todos
	@GetMapping	
	@ApiOperation(value = "Listar Usuários ", notes = "Listar Usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<List<UserDisplay>> listAll() {
		List<UserDisplay> listFile = userService.searchAll();
		return ResponseEntity.ok(listFile);
	}
	
	// inserir
	@PostMapping
	@ApiOperation(value = "Inserir Usuários ", notes = "Inserir Usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários inseridos com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<Object> addUser (@Valid @RequestBody UserAdd userAdd){
		UserDisplay userDisplay = userService.addUser(userAdd);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userDisplay.getId()).toUri();
		return ResponseEntity.created(uri).body(userAdd);
	}
	
	// Buscar por id
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar usuário por ID", notes = "Buscar usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	public ResponseEntity<UserDisplay> listId(@PathVariable Long id){
		UserDisplay user = userService.search(id);
		if(null != user) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}
	
	// Atualizar
		@PutMapping("/{id}")
		@ApiOperation(value = "Atualizar usuário por ID", notes = "Atualizar usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		public ResponseEntity<UserDisplay> atualizar(@PathVariable Long id,
				@RequestBody UserAdd userAdd) {
			UserDisplay userDisplay =userService.update(id, userAdd);
			if (userDisplay == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(userDisplay);
		}
	
	

	// Deletar
		@DeleteMapping("/{id}")
		@ApiOperation(value = "Excluir usuário por ID", notes = "Excluir usuário por ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário excluído com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			if(!userService.delete(id)) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.noContent().build();
		}
	
}
