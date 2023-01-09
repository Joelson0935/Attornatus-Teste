package com.casa.dio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casa.dio.model.Endereco;
import com.casa.dio.model.Pessoa;
import com.casa.dio.repository.EnderecoRepository;
import com.casa.dio.repository.PessoaRepository;
import com.casa.dio.service.Services;
import com.casa.dio.service.ViaCepService;

@Service
public class PessoaImpl implements Services<Pessoa> {

	@Autowired
	public PessoaRepository pessoaRepository;

	@Autowired
	public EnderecoRepository enderecoRepository;

	@Autowired
	public ViaCepService viaCepService;

	@Override
	public Iterable<Pessoa> buscarTodos() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Objeto " + id + " não encontrado"));
		return pessoa;
	}

	/**
	 * Cria uma nova pessoa e caso a pessoa não possua o endereço eu busco um usando
	 * o cep como argumento de busca através da interface de busca criada.
	 */
	
	@Override
	public Pessoa inserir(Pessoa pessoa) {
		String cep = pessoa.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		pessoa.setEndereco(endereco);
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaEncontrada = buscarPorId(id);
		if (pessoaEncontrada != null) {
			inserir(pessoaEncontrada);
		}
		return pessoaEncontrada;
	}

	@Override
	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

}
