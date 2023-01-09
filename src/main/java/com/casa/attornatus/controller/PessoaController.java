package com.casa.attornatus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casa.attornatus.model.Pessoa;
import com.casa.attornatus.service.Services;

import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/Pessoas")
@RestController
@Tag(name = "Pessoa", description = "Api para cadastro de pessoas")
public class PessoaController {

	@Autowired
	public Services<Pessoa> pessoaService;

	@PostMapping("/Inserir")
	public ResponseEntity<Pessoa> inserirPessoa(@Valid @RequestBody Pessoa pessoa) {
		pessoaService.inserir(pessoa);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
	}

	@GetMapping("/Buscar/{id}")
	public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		if (pessoa != null) {
			return ResponseEntity.ok(pessoa);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/BuscarTodos")
	public ResponseEntity<Iterable<Pessoa>> buscarListaDePessoas() {
		Iterable<Pessoa> pessoas = pessoaService.buscarTodos();
		return ResponseEntity.ok(pessoas);
	}

	@PutMapping("/Atualizar/{pessoaId}")
	public ResponseEntity<Pessoa> atualizarPessoaPorId(@Valid @PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {
		Pessoa pessoaEncontrada = pessoaService.buscarPorId(pessoaId);
		if (pessoaEncontrada.getId() != null) {
			pessoa.setId(pessoaId);
			pessoaService.inserir(pessoa);
			return ResponseEntity.ok(pessoa);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/DeletePessoa")
	public ResponseEntity<Void> deletarPessoaPorId(@RequestParam(name = "deleteId") Long deleteId) {
		Pessoa pessoa = pessoaService.buscarPorId(deleteId);
		if (pessoa == null) {
			return ResponseEntity.notFound().build();
		}
		pessoaService.deletar(deleteId);
		return ResponseEntity.noContent().build();
	}

}
